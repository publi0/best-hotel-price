package controller.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtil {
    public static boolean IsWeekend(LocalDate date)
    {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}