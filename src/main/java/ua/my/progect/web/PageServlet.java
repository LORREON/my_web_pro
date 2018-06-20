package ua.my.progect.web;

import org.slf4j.Logger;
import ua.my.progect.model.Page;
import ua.my.progect.repository.InMemoryUserPages;
import ua.my.progect.repository.UserPageRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;

public class PageServlet extends HttpServlet {
    private static final Logger log = getLogger(PageServlet.class);

    private UserPageRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = new InMemoryUserPages();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                log.info("Delete {}", id);
                repository.delete(id);
                response.sendRedirect("pages");
                break;
            case "create":
            case "update":
                final Page npage = "create".equals(action) ?
                        new Page(null, "new Page", "user", LocalDateTime.now(), "new text") :
                        repository.get(getId(request));
                request.setAttribute("npage", npage);
                request.getRequestDispatcher("/pageForm.jsp").forward(request, response);
                System.out.println(npage.toString());
                break;
            case "all":
            default:
                log.info("getAll");
                request.setAttribute("pageList", repository.getAll());
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

        log.info(page.isNew() ? "Create {}" : "Update {}", page);
        repository.save(page);
        resp.sendRedirect("pages");
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }


}
