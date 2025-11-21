package collections;

import java.util.ArrayList;
import java.util.List;

public class ListMain {

    public static void main(String[] args) {
        List nomes = new ArrayList(); //1.4
        nomes.add("Bruno");
        nomes.add("teste123");
        nomes.add(121);
        nomes.add(true);

        nomes.remove(0);
        nomes.remove(true);

        for(Object nome : nomes){
            System.out.println(nome);
        }

        List<String> nomes2 = new ArrayList(); //1.5
        nomes2.add("Bruno");
        nomes2.add("teste123");

        for(Object nome : nomes2){
            System.out.println(nome);
        }

        for(int i = 0; i < nomes2.size(); i++){
            System.out.println(nomes2.get(i));
        }



        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);

        System.out.println(numeros);


        nomes.addAll(nomes2);
        System.out.println(nomes);
    }
}
