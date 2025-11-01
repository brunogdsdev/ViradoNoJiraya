package behavior;

public class AnimeComparators {

    public static int compareByName(Anime a1, Anime a2){
        return a1.getName().compareTo(a2.getName());
    }

    public static int compareByEpisodes(Anime a1, Anime a2){
        return Integer.compare(a1.getEpisodes(), a2.getEpisodes());
    }
}
