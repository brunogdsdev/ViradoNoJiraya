package streams;

import behavior.Anime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamMain05 {
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

        List<Integer> nums = List.of(1,2,3,4,5,6,7);

        nums.stream().reduce((x,y) -> x + y).ifPresent(System.out::println);

        System.out.println(nums.stream().reduce(0, (x,y) -> x + y));

        System.out.println(nums.stream().reduce(0,Integer::sum));


        System.out.println("======================================");
        nums.stream().reduce((x,y) -> x > y ? x : y).ifPresent(System.out::println);
        System.out.println(nums.stream().reduce(0,Integer::max));
    }
}
