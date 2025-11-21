package Utils.Date;

import java.time.LocalDate;
import java.time.Period;

public class PeriodMain {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        LocalDate after = LocalDate.now().plusYears(2).plusDays(7);

        Period p1 = Period.between(now,after);
        Period p2 = Period.ofDays(7);
        Period p3 = Period.ofWeeks(9);
        Period p4 = Period.ofMonths(7);
        Period p5 = Period.ofYears(7);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);

    }
}
