package streams;

import behavior.Anime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static List<Anime> animeList = new ArrayList<>(List.of(
            new Anime("Naruto", 100),
            new Anime("Dragon Ball", 200),
            new Anime("One Peace", 300),
            new Anime("Bleach", 400),
            new Anime("Beserk", 500),
            new Anime("Boku no Hero", 600),
            new Anime("Boruto", 700)
    ));

    public static void main(String[] args) {
        animeList.sort(Comparator.comparing(Anime::getName));

        List<String> titles = new ArrayList<>();
        for(Anime anime : animeList){
            if(anime.getEpisodes() <= 400){
                titles.add(anime.getName());
            }

            if(titles.size() >=3){
                break;
            }
        }


        System.out.println(titles);


        /// USANDO STREAMS

        List<String> collected = animeList.stream()
                .sorted(Comparator.comparing(Anime::getName))
                .filter(a -> a.getEpisodes() <= 400)
                .limit(3)
                .map(Anime::getName)
                .collect(Collectors.toList());

        System.out.println(collected);
    }
}
