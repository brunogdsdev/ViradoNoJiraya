package streams;

import behavior.Anime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain02 {
    public static List<Anime> animeList = new ArrayList<>(List.of(
            new Anime("Naruto", 100),
            new Anime("Naruto", 100),
            new Anime("Naruto", 100),
            new Anime("Naruto", 100),
            new Anime("Dragon Ball", 200),
            new Anime("One Peace", 300),
            new Anime("Bleach", 400),
            new Anime("Beserk", 500),
            new Anime("Boku no Hero", 600),
            new Anime("Boruto", 700)
    ));

    public static void main(String[] args) {
        animeList.stream().forEach(System.out::println);
        Stream<Anime> stream = animeList.stream();

        long count = stream.filter(ln -> ln.getEpisodes() <= 400).count();

        stream = animeList.stream();
        long count2 = stream.distinct().filter(ln -> ln.getEpisodes() <= 400).count();

        System.out.println(count);
        System.out.println(count2);


        List<List<String>> dev = new ArrayList<>();


        List<String> names1 = List.of("Bruno", "Gaby", "Tony");
        List<String> names2 = List.of("TESTE1", "TESTE2", "TESTE3");
        List<String> names3 = List.of("Bruno3", "Gaby2", "Tony1");

        dev.add(names1);
        dev.add(names2);
        dev.add(names3);

        for (List<String> list : dev) {
            for (String s : list) {
                System.out.println(s);
            }

        }

        System.out.println("--------------------------------------------");

        dev.stream().flatMap(Collection::stream).forEach(System.out::println);

    }
}
