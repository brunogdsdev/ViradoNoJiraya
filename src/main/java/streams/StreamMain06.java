package streams;

import behavior.Anime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamMain06 {
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
        int sum = 0;

        // PRIMEIRA FORMA
        Optional<Integer> total = animeList.stream()
                .map(Anime::getEpisodes)
                .filter(n -> n > 500)
                .reduce(Integer::sum);

        if(total.isPresent()){
            sum = total.get();
            System.out.println(sum);
        }


        // SEGUNDA FORMA
        int sum2 = animeList.stream()
                .map(Anime::getEpisodes)
                .filter(n -> n > 500)
                .reduce(Integer::sum).orElse(0);

        System.out.println(sum2);


        // TERCEIRA FORMA
        int sum3 = animeList.stream().mapToInt(Anime::getEpisodes).filter(n -> n > 500).sum();
        System.out.println(sum3);


    }
}
