package collections;

import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Manga> mangas = new HashSet<>(); // oou LinkedHashSet para manter a ordem de insercao

        mangas.add(new Manga("pokemon", 21L, 14, 20));
        mangas.add(new Manga("digimon", 2L, 4, 2));
        mangas.add(new Manga("naruto", 111L, 1, 100));
        mangas.add(new Manga("one piece",221L,11, 22));
        mangas.add(new Manga("dragon ball", 511L, 10, 0));
        mangas.add(new Manga("dragon ball", 511L, 10, 0));
        mangas.add(new Manga("dragon ball", 511L, 10, 0));


        for(Manga manga : mangas){
            System.out.println(manga);
        }

    }
}
