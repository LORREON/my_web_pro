package ua.my.progect.model;


import java.time.LocalDateTime;


public class Page extends AbstractNamedEntity {

    private final String userName;
    private final LocalDateTime pageDateTime;
    private String text;


    protected Page(Integer id, String name, String userName, String text) {
        this(id, name, userName, LocalDateTime.now(), text);
    }

    public Page(Integer id, String name, String userName, LocalDateTime pageDateTime, String text) {
        super(id, name);
        this.userName = userName;
        this.pageDateTime = pageDateTime;
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getDateTime() {
        return pageDateTime;
    }

    public String getText() {
        return text;
    }


}
