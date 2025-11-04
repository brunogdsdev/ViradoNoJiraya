package behavior;

import java.util.Comparator;

public class Anime implements Comparator<Anime> {
    private String name;
    private int episodes;

    public Anime(String name, int episodes) {
        this.name = name;
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "name='" + name + '\'' +
                ", episodes=" + episodes +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    @Override
    public int compare(Anime anime, Anime t1) {
        return anime.getName().compareTo(t1.getName());
    }
}
