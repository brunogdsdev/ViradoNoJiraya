package collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("A1", "apple");
        Smartphone s2 = new Smartphone("B1", "noquia");
        Smartphone s3 = new Smartphone("C1", "sangung");
        Smartphone s4 = new Smartphone("D1", "zioami");

        List<Smartphone> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

//        list.clear();
        for(Smartphone s : list){
            System.out.println(s.toString());
        }

        Smartphone s5 = new Smartphone("E1", "novo");
        System.out.println(list.contains(s5));
        System.out.println(list.indexOf(s5)+ " | "+ list.indexOf(s4));

        System.out.println("---------------------");
        list.add(0,s5);
        System.out.println(list);
        System.out.println(list.contains(s5));
        System.out.println(list.indexOf(s5)+ " | "+ list.indexOf(s4));

        int index = list.indexOf(s2);
        System.out.println(list.get(index));

        Smartphone teste = list.get(index);

        teste.setSerialNumber("MUDOU");
        System.out.println(list.get(index));



    }
}
