package ua.my.progect.model;

import java.time.LocalDateTime;

public class Page {
    protected Integer id;
    protected String pageName;
    protected String userName;
    protected LocalDateTime pageDateTime;
    protected String text;

    public Page(Integer id, String pageName, String userName, LocalDateTime pageDateTime, String text) {
        this.id = id;
        this.pageName = pageName;
        this.userName = userName;
        this.pageDateTime = pageDateTime;
        this.text = text;
    }

    public Page() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isNew(){
        return id == null;
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
