package ua.my.progect.util;

import ua.my.progect.model.Page;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static final List<Page> PAGE_LIST = Arrays.asList(
        new Page(null, "Start page", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(null,"Options page", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(null,"Page_1", "user", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(null,"Page_2", "user", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(null,"Page_3", "user", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(null,"Page_4", "user", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(null,"Page_5", "user", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(null,"Page_6", "user", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text")
    );

    public Util() {
    }

    public static List<Page> getPageList() {
        return PAGE_LIST;
    }
}
