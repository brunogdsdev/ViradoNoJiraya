package Utils.Date;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitMain {
    public static void main(String[] args) {

        LocalDateTime birth = LocalDateTime.of(1995, 11,19, 23,59);
        LocalDateTime now = LocalDateTime.now();

        System.out.println(ChronoUnit.DAYS.between(birth, now));
        System.out.println(ChronoUnit.MONTHS.between(birth, now));
        System.out.println(ChronoUnit.WEEKS.between(birth, now));
        System.out.println(ChronoUnit.YEARS.between(birth, now));

    }
}
