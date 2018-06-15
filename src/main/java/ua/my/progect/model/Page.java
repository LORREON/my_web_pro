package ua.my.progect.model;

import java.time.LocalDateTime;

public class Page {
    private String pageName;
    private String userName;
    private LocalDateTime pageDateTime;
    private String text;

    public Page(String pageName, String userName, LocalDateTime pageDateTime, String text) {
        this.pageName = pageName;
        this.userName = userName;
        this.pageDateTime = pageDateTime;
        this.text = text;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getPageDateTime() {
        return pageDateTime;
    }

    public void setPageDateTime(LocalDateTime pageDateTime) {
        this.pageDateTime = pageDateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageName='" + pageName + '\'' +
                ", userName='" + userName + '\'' +
                ", pageDateTime=" + pageDateTime +
                '}';
    }
}
