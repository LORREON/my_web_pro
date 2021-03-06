package ua.my.progect.web.page;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.my.progect.AuthorizedUser;
import ua.my.progect.model.Page;
import ua.my.progect.service.PageService;

import java.util.List;

import static ua.my.progect.util.ValidationUtil.assureIdConsistent;
import static ua.my.progect.util.ValidationUtil.checkNew;

@Controller
public class PageRestController {
    private static final Logger log = LoggerFactory.getLogger(PageRestController.class);

    private final PageService service;

    @Autowired
    public PageRestController(PageService service) {
        this.service = service;
    }

    public Page get(int id) {
        int userId = AuthorizedUser.id();
        log.info("get meal {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = AuthorizedUser.id();
        log.info("delete meal {} for user {}", id, userId);
        service.delete(id, userId);
    }

    public List<Page> getAll() {
        int userId = AuthorizedUser.id();
        log.info("getAll for user {}", userId);
        return service.getAll(userId);
    }

    public Page create(Page page) {
        int userId = AuthorizedUser.id();
        checkNew(page);
        log.info("create {} for user {}", page, userId);
        return service.create(page, userId);
    }

    public void update(Page page, int id) {
        int userId = AuthorizedUser.id();
        assureIdConsistent(page, id);
        log.info("update {} for user {}", page, userId);
        service.update(page, userId);
    }

}