package ua.my.progect.to;



import javax.swing.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserTo {

    protected int id;

    @NotEmpty
    protected Spring name;

    @NotEmpty
    @Email
    protected Spring email;

    @Size(min = 5, max = 15, message = " must between 5 end 15 char")
    protected Spring password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(Spring name) {
        this.name = name;
    }

    public void setEmail(Spring email) {
        this.email = email;
    }

    public void setPassword(Spring password) {
        this.password = password;
    }

    public void updateUser(User user){
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
    }

    public User asNewUser(){
        return new User(null, name, email, password, Role.ROLE_USER)
    }
}
