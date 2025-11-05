package streams;

import behavior.Anime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain10 {

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
        Map<Category, List<Anime>> list = new HashMap<>();

        List<Anime> fantasyList = new ArrayList<>();
        List<Anime> actionList = new ArrayList<>();
        List<Anime> romanceList = new ArrayList<>();

        for(Anime anime : animeList){
            switch (anime.getCategory()){
                case ACTION: actionList.add(anime); break;
                case ROMANCE: romanceList.add(anime); break;
                case FANTASY: fantasyList.add(anime); break;
                default: break;
            }
        }

        list.put(Category.ACTION, actionList);
        list.put(Category.FANTASY, fantasyList);
        list.put(Category.ROMANCE,romanceList);

        System.out.println(list);
        System.out.println("===================== stream");


        Map<Category, List<Anime>> categoryListMap = animeList.stream().collect(Collectors.groupingBy(Anime::getCategory));

        System.out.println(categoryListMap);


    }

}
