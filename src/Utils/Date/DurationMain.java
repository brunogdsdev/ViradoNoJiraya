package Utils.Date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DurationMain {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowAfterTwoYears = LocalDateTime.now().plusYears(2);

        LocalTime timeNow = LocalTime.now();
        LocalTime timeAfter7Min = LocalTime.now().plusMinutes(7);

        Duration d1 = Duration.between(now, nowAfterTwoYears);
        Duration d2 = Duration.between(timeNow, timeAfter7Min);

        System.out.println(d1);
        System.out.println(d2);


    }
}
