package ua.my.progect.util;

import ua.my.progect.model.Page;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static final List<Page> PAGE_LIST = Arrays.asList(
        new Page(1, "Start page", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(2,"Options page", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(3,"Page_1", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(4,"Page_2", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(5,"Page_3", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(6,"Page_4", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(7,"Page_5", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text"),
        new Page(8,"Page_6", "admin", LocalDateTime.of(2018, Month.JULY, 1, 10, 0), "Page text")
    );

    public Util() {
    }

    public static List<Page> getPageList() {
        return PAGE_LIST;
    }
}
