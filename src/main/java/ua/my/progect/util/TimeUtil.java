package ua.my.progect.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" :ldt.format(DATE_TIME_FORMATTER);
    }
}
