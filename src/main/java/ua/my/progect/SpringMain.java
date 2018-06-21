package ua.my.progect;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.my.progect.model.Page;
import ua.my.progect.model.Role;
import ua.my.progect.model.User;
import ua.my.progect.web.page.PageRestController;
import ua.my.progect.web.user.AdminRestController;

import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            adminUserController.create(new User(null, "userName", "email", "password", Role.ROLE_ADMIN));
            System.out.println();

            PageRestController pageRestController = appCtx.getBean(PageRestController.class);
            List<Page> pageList = pageRestController.getAll();
            pageList.forEach(System.out::println);
        }
    }
}
