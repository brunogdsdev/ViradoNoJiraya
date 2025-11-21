package streams;

import behavior.Anime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain03 {
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
        List<String> words = List.of("Teste", "123", "Teste");

        String[] split = words.get(0).split("");
//        String[] split = words.getFirst().split("");

        System.out.println(Arrays.toString(split));

        List<String[]> collect = words.stream().map(w -> w.split("")).collect(Collectors.toList());
        Stream<String> stream = Arrays.stream(split);

        List<String> letters = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        System.out.println(letters);
    }
}
