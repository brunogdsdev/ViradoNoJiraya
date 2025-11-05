package streams;

import behavior.Anime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain09 {
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
        System.out.println(animeList.stream().count());
        System.out.println(animeList.stream().collect(Collectors.counting()));


        animeList.stream()
                .max(Comparator.comparing(Anime::getEpisodes)).ifPresent(System.out::println);

        animeList.stream()
                .min(Comparator.comparing(Anime::getEpisodes)).ifPresent(System.out::println);

        animeList.stream()
                .collect(
                        Collectors.maxBy(Comparator.comparing(Anime::getEpisodes))
                )
                .ifPresent(System.out::println);

        animeList.stream()
                .collect(
                        Collectors.minBy(Comparator.comparing(Anime::getEpisodes))
                )
                .ifPresent(System.out::println);

        System.out.println(animeList.stream().mapToDouble(Anime::getEpisodes).sum());
        System.out.println(animeList.stream().collect(Collectors.summingDouble(Anime::getEpisodes)));

        animeList.stream().mapToDouble(Anime::getEpisodes).average().ifPresent(System.out::println);
        System.out.println(animeList.stream().collect(Collectors.averagingDouble(Anime::getEpisodes)));

        System.out.println();


        DoubleSummaryStatistics collected = animeList.stream().collect(Collectors.summarizingDouble(Anime::getEpisodes));

        System.out.println(collected);
        System.out.println();


        String collected1 = animeList.stream().map(Anime::getName).collect(Collectors.joining(", "));
        System.out.println(collected1);


    }
}
