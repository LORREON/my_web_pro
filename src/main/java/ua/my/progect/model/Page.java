package ua.my.progect.model;


import java.time.LocalDateTime;

public class Page {
    private Integer id;
    private String name;
    private String userName;
    private LocalDateTime pageDateTime;
    private String text;


    public Page() {
    }

    public Page(Integer id, String name, String userName, LocalDateTime pageDateTime, String text) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.pageDateTime = pageDateTime;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
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

    public boolean isNew() {
        return this.id == null;
    }

}
