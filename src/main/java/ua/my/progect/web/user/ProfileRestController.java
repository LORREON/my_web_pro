package ua.my.progect.web.user;


import org.springframework.stereotype.Controller;
import ua.my.progect.model.User;
import ua.my.progect.web.AuthorizedUser;

@Controller
public class ProfileRestController extends AbstractUserController {

    public User get() {
        return super.get(AuthorizedUser.id());
    }

    public void delete() {
        super.delete(AuthorizedUser.id());
    }

    public void update(User user) {
        super.update(user, AuthorizedUser.id());
    }
}