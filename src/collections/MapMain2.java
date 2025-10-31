package collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class MapMain2 {
    public static void main(String[] args) {

        Consumidor consumidor = new Consumidor("Bruno");
        Consumidor consumidor2 = new Consumidor("BrunoGomes");


        Manga manga1 = new Manga("pokemon", 21L, 14, 20);
        Manga manga2 = new Manga("digimon", 2L, 4, 2);
        Manga manga3 = new Manga("naruto", 111L, 1, 100);
        Manga manga4 = new Manga("one piece",221L,11, 22);
        Manga manga5 = new Manga("dragon ball", 511L, 10, 0);

        Map<Consumidor, List<Manga>> banca = new HashMap<>();

        List<Manga> pacote1 = List.of(manga1, manga2, manga3);


        banca.put(consumidor, pacote1);
        banca.put(consumidor2, List.of(manga4));

        for(Map.Entry<Consumidor, List<Manga>> entry : banca.entrySet()){
            for(Manga m : entry.getValue()){
                System.out.println(entry.getKey()+ " ==> "+ m.getNome());
            }
        }

    }
}

