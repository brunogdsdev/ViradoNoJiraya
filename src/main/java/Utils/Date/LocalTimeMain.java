package Utils.Date;

import java.time.LocalTime;

public class LocalTimeMain {
    public static void main(String[] args) {
        LocalTime t = LocalTime.of(3,40,10);
        LocalTime now = LocalTime.now();

        System.out.println(t);
        System.out.println(now);

        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIDNIGHT);
    }
}
