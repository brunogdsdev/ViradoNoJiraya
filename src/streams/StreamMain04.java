package streams;

import behavior.Anime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class StreamMain04 {
    public static List<Anime> animeList = new ArrayList<>(List.of(
            new Anime("Naruto", 100),
            new Anime("Naruto", 10),
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

        System.out.println(animeList.stream().anyMatch(ln -> ln.getEpisodes() > 600));
        System.out.println(animeList.stream().allMatch(ln -> ln.getEpisodes() > 99));
        System.out.println(animeList.stream().noneMatch(ln -> ln.getEpisodes() > 99));


        animeList.stream().filter(ln -> ln.getEpisodes() > 3).findAny().ifPresent(System.out::println);
        animeList.stream()
                .filter(ln -> ln.getEpisodes() > 3)
                .sorted(Comparator.comparing(Anime::getEpisodes))
                .findFirst()
                .ifPresent(System.out::println);



    }
}
