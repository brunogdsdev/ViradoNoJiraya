package streams;

import behavior.Anime;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMain11 {
    public static List<Anime> animeList = new ArrayList<>(List.of(
            new Anime("Naruto", 100, Category.FANTASY),
            new Anime("Naruto", 10, Category.FANTASY),
            new Anime("Naruto", 100, Category.FANTASY),
            new Anime("Naruto", 100, Category.FANTASY),
            new Anime("Dragon Ball", 200, Category.ACTION),
            new Anime("One Peace", 300, Category.FANTASY),
            new Anime("Bleach", 400 , Category.ACTION),
            new Anime("Beserk", 500, Category.ACTION),
            new Anime("Boku no Hero", 600, Category.DRAMA),
            new Anime("Boruto", 700, Category.ROMANCE)
    ));
    public static void main(String[] args) {
        Map<Category, DoubleSummaryStatistics> collected = animeList.stream().collect(Collectors.groupingBy(Anime::getCategory, Collectors.summarizingDouble(Anime::getEpisodes)));

        System.out.println(collected);

    }
}
