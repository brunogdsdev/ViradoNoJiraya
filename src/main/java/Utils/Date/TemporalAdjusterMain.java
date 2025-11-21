package Utils.Date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterMain {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        now = now.with(ChronoField.DAY_OF_MONTH, 20);
        System.out.println(now);
        System.out.println(now.getDayOfWeek());


        LocalDate now2 = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        System.out.println(now2);
        System.out.println(now2.getDayOfWeek());


        LocalDate now3 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(now3);
        System.out.println(now3.getDayOfWeek());

        LocalDate now4 = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SATURDAY));
        System.out.println(now4);
        System.out.println(now4.getDayOfWeek());

        System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear()));



    }
}
