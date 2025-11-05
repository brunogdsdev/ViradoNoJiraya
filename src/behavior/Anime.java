package behavior;

import streams.Category;

import java.util.Comparator;

public class Anime implements Comparator<Anime> {
    private String name;
    private int episodes;
    private Category category;

    public Anime(String name, int episodes, Category category) {
        this.name = name;
        this.episodes = episodes;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Anime(String name, int episodes) {
        this.name = name;
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "name='" + name + '\'' +
                ", episodes=" + episodes +
                ", category=" + category +
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
