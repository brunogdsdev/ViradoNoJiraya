package Utils.Date;

import java.util.Calendar;
import java.util.Date;

public class CalendarMain {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        if(c.getFirstDayOfWeek() == Calendar.SUNDAY){
            System.out.println("Domingo");
        }

        System.out.println(Calendar.DAY_OF_WEEK);
        System.out.println(Calendar.DAY_OF_MONTH);
        System.out.println(Calendar.DAY_OF_YEAR);
        System.out.println(Calendar.DAY_OF_WEEK_IN_MONTH);

        c.add(Calendar.DAY_OF_MONTH, 2);
        c.roll(Calendar.DAY_OF_MONTH, 2);


        Date d = c.getTime();
        System.out.println(c);
        System.out.println(d);
    }
}
