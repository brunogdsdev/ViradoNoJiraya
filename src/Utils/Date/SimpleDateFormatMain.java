package Utils.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatMain {

    public static void main(String[] args) {
        String pattern = "dd/MM/YYYY";
        SimpleDateFormat s =  new SimpleDateFormat(pattern);

        System.out.println(s.format(new Date()));

        try{
            System.out.println(s.parse("17/10/2025"));
        }catch (ParseException e){
            e.printStackTrace();
        }

    }
}
