package utils;

import java.time.DayOfWeek;

public class IsWeekEnd {

    public static boolean IsWeekEndCheck(DayOfWeek day) {
        return day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY);
    }

}
