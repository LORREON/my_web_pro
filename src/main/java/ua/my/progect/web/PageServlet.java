package ua.my.progect.web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.my.progect.model.Page;
import ua.my.progect.web.page.PageRestController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;


public class PageServlet extends HttpServlet {

    private ConfigurableApplicationContext springContext;
    private PageRestController pageController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        pageController = springContext.getBean(PageRestController.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                pageController.delete(id);
                response.sendRedirect("pages");
                break;
            case "create":
            case "update":
                final Page npage = "create".equals(action) ?
                        new Page(null, "new Page", "user", LocalDateTime.now(), "new text") :
                        pageController.get(getId(request));
                request.setAttribute("npage", npage);
                request.getRequestDispatcher("/pageForm.jsp").forward(request, response);
                System.out.println(npage.toString());
                break;
            case "all":
            default:
                request.setAttribute("pageList", pageController.getAll());
                request.getRequestDispatcher("/pages.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");

        Page page = new Page(id.isEmpty() ? null : Integer.valueOf(id),
                req.getParameter("pageName"),
                req.getParameter("userName"),
                LocalDateTime.parse(req.getParameter("pageDateTime")),
                req.getParameter("text"));

        if (id.isEmpty()) {
            pageController.create(page);
        } else {
            pageController.update(page, getId(req));
        }

        resp.sendRedirect("pages");
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }

}
