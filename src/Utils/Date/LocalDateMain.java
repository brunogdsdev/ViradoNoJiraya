package Utils.Date;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class LocalDateMain {

    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(Calendar.getInstance().getTime());

        System.out.println(Month.JANUARY.getValue());

        LocalDate date = LocalDate.of(2025,Month.OCTOBER, 17);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfYear());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());


        LocalDate agora = LocalDate.now();
        System.out.println(agora);
        System.out.println(agora.plusDays(4));
        System.out.println(agora.plusWeeks(4));
        System.out.println(agora.plusMonths(4));
        System.out.println(agora.plusYears(4));
    }
}
