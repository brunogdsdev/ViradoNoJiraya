package collections;

import java.util.*;

public class BinarySearchMain {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();

        numeros.add(1);
        numeros.add(5);
        numeros.add(8);
        numeros.add(6);
        numeros.add(2);

        Collections.sort(numeros);

        System.out.println(numeros);
        System.out.println(Collections.binarySearch(numeros, 6));


        System.out.println("=================================== exemplo 2");


        List<Manga> mangas = new ArrayList<>();

        mangas.add(new Manga("Naruto", 1L, 22.1));
        mangas.add(new Manga("Teste", 5L, 2.12));
        mangas.add(new Manga("Power ranger", 4L, 12.0));
        mangas.add(new Manga("Tom e jerry", 3L, 102.5));

//        Collections.sort(mangas); // por nome

        mangas.sort(new MangaByIdComparator()); // por id
        for(Manga m : mangas){
            System.out.println(m);
        }

        Manga mangaToSearch= new Manga("Tom e jerry", 3L, 102.5);
        System.out.println(Collections.binarySearch(mangas, mangaToSearch, new MangaByIdComparator()));
    }
}
