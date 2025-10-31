package collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue<String> fila = new PriorityQueue<>();

        fila.add("C");
        fila.add("A");
        fila.add("B");

        System.out.println(!fila.isEmpty());
        System.out.println(" =>"+ fila.poll());
        for (String s : fila) {
            System.out.println(s);
        }

        System.out.println(fila);



//        DA ERRO PQ NAO IMPLEMENTA COMPARABLE
//        Consumidor consumidor = new Consumidor("Bruno");
//        Queue<Consumidor> consumidores = new PriorityQueue<>();
//        consumidores.add(consumidor);


        Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator().reversed());
        mangas.add(new Manga("pokemon", 21L, 14, 20));
        mangas.add(new Manga("digimon", 2L, 4, 2));
        mangas.add(new Manga("naruto", 111L, 1, 100));
        mangas.add(new Manga("one piece",221L,11, 22));
        mangas.add(new Manga("dragon ball", 511L, 10, 0));
        mangas.add(new Manga("dragon ball", 511L, 10, 0));
        mangas.add(new Manga("dragon ball", 511L, 10, 0));

        while(!mangas.isEmpty()){
            System.out.println(mangas.poll());
        }
    }
}
