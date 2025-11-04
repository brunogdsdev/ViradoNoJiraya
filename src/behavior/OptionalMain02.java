package behavior;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalMain02 {
    private static List<Anime> animeList = List.of(new Anime("Naruto", 10), new Anime("Teste", 500));
    public static void main(String[] args) {
        Optional<Anime> animeByTitle = OptionalMain02.findByTitle("Naruto");
        animeByTitle.ifPresent(a -> a.setName("Naruto Shippuden"));
        System.out.println(animeByTitle);


        Anime animeByEpisodes = OptionalMain02.findByEpisodes(10) // retorna esse erro especifico se nao encontrar
                .orElseThrow(IllegalAccessError::new);
        System.out.println(animeByEpisodes);


        Anime newAnime = OptionalMain02.findByTitle("Dragon Ball")
                .orElseGet(() -> new Anime("Dragon Ball", 700)); // CRIA CASO NAO EXISTA

        System.out.println(newAnime);


    }


    public static Optional<Anime> findByEpisodes(int episodes){
        return findBy(anime -> anime.getEpisodes() == episodes);
    }

    public static Optional<Anime> findByTitle(String title){
        return findBy(anime -> anime.getName().equals(title));
    }


    private static Optional<Anime> findBy(Predicate<Anime> predicate){
        Anime found = null;
        for(Anime anime :  animeList){
            if(predicate.test(anime)){
                found = anime;
            }
        }
        return Optional.ofNullable(found);
    }
}
