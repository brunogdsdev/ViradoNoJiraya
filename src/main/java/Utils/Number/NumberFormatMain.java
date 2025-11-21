package Utils.Number;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatMain {
    public static void main(String[] args) {
        Locale l = new Locale("pt", "BR");
        double valor = 10_000_000.45;

        NumberFormat n = NumberFormat.getInstance();
        NumberFormat n2 = NumberFormat.getInstance(Locale.JAPAN);

        NumberFormat v = NumberFormat.getCurrencyInstance();
        NumberFormat v2 = NumberFormat.getCurrencyInstance(Locale.JAPAN);

        System.out.println(n.format(valor));
        System.out.println(n2.format(valor));

        System.out.println(v.format(valor));
        System.out.println(v2.format(valor));


    }
}
