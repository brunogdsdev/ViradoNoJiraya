package collections;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneMarcaComparator implements Comparator<Smartphone>{
    @Override
    public int compare(Smartphone o, Smartphone t1) {
        return o.getMarca().compareTo(t1.getMarca());
    }
}


class MangaPrecoComparator implements Comparator<Manga>{

    @Override
    public int compare(Manga manga, Manga t1) {
        return Double.compare(manga.getPreco(), t1.getPreco());
    }
}


public class NavigableSetMain {
    public static void main(String[] args) {
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());

        Smartphone nokia = new Smartphone("123", "nokia");
        set.add(nokia);


        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        mangas.add(new Manga("pokemon", 21L, 14, 20));
        mangas.add(new Manga("digimon", 2L, 4, 2));
        mangas.add(new Manga("naruto", 111L, 1, 100));
        mangas.add(new Manga("one piece",221L,11, 22));
        mangas.add(new Manga("dragon ball", 511L, 10, 0));
        mangas.add(new Manga("dragon ball", 511L, 10, 0));
        mangas.add(new Manga("dragon ball", 511L, 12, 0));


        for(Manga manga : mangas.descendingSet()){
            System.out.println(manga);
        }


        // lower <
        // floor <=
        // higher >
        // ceiling >=
        Manga yuyu = new Manga("Yuyu hakusho", 9L, 12, 2);

        System.out.println("-------------------------------");
        System.out.println(mangas.lower(yuyu));
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));

        System.out.println("-------------------------------");
        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst());
        System.out.println(mangas.pollLast());
        System.out.println(mangas.size());

        for(Manga manga : mangas.descendingSet()){
            System.out.println(manga);
        }
    }
}
