package behavior;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceMain {

    public static void main(String[] args) {
        List<Anime> animes = new ArrayList<>(List.of(new Anime("Naruto", 500), new Anime("Dragon ball", 10000)));

//        Collections.sort(animes, new Comparator<Anime>(){
//            @Override
//            public int compare(Anime o1, Anime o2){
//                return Integer.compare(o1.getEpisodes(), o2.getEpisodes());
//            }
//        });


//        Collections.sort(animes, (a1, a2) -> a1.getName().compareTo(a2.getName()));


//        Collections.sort(animes, (a1,a2) -> AnimeComparators.compareByName(a1,a2));


//        Collections.sort(animes, AnimeComparators::compareByName);
        animes.sort(AnimeComparators::compareByEpisodes);
        System.out.println(animes);
    }
}
