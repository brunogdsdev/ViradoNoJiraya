package Utils.format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormaterMain {

    public static void main(String[] args) {
         DateTimeFormatter formatBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String d = LocalDate.now().format(formatBR);
        System.out.println(d);


        LocalDate e = LocalDate.parse(d, formatBR);
        System.out.println(e);


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.GERMAN);

        System.out.println(LocalDate.now().format(dateTimeFormatter));
    }
}
