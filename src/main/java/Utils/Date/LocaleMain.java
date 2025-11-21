package Utils.Date;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleMain {
    public static void main(String[] args) {
        Locale l = new Locale("pt", "BR");
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, l);

        Calendar c = Calendar.getInstance();
        System.out.println(df1.format(c.getTime()));

        System.out.println(Locale.getDefault());


        String[] isoCountries = Locale.getISOCountries();
        String[] isoLanguages = Locale.getISOLanguages();

        for(String isoC : isoCountries ){
            System.out.print(isoC+", ");
        }

        System.out.println();
        for(String isoL : isoLanguages ){
            System.out.print(isoL+", ");
        }
    }
}
