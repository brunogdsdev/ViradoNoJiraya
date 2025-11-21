package Utils.Date;

import java.text.DateFormat;
import java.util.Calendar;

public class DateFormatMain {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        DateFormat[] df = new DateFormat[7];

        df[0] = DateFormat.getInstance(); //17/10/2025 04:02
        df[1] = DateFormat.getDateInstance(); //17 de out. de 2025
        df[2] = DateFormat.getDateTimeInstance(); //17 de out. de 2025 04:02:35
        df[3] = DateFormat.getDateInstance(DateFormat.SHORT); //17/10/2025
        df[4] = DateFormat.getDateInstance(DateFormat.MEDIUM); //17 de out. de 2025
        df[5] = DateFormat.getDateInstance(DateFormat.LONG);//17 de outubro de 2025
        df[6] = DateFormat.getDateInstance(DateFormat.FULL);//sexta-feira, 17 de outubro de 2025

        for(DateFormat d : df){
            System.out.println(d.format(c.getTime()));
        }

    }
}
