package ua.my.progect.model;

import java.time.LocalDateTime;

public class User {
    private  final String userName;

    private final String pass;

    private final LocalDateTime dateTime;

    private final String description;

    public User(String userName, String pass, LocalDateTime dateTime, String description) {
        this.userName = userName;
        this.pass = pass;
        this.dateTime = dateTime;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
