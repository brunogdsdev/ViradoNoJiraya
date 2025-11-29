package junitjava;

import crud.dominio.Anime;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnimeService {

    public boolean isShortAnime(Anime a){
        Objects.requireNonNull(a, "Anime can't be null");
        return a.getEpisodes() < 10;
    }

    public boolean isLongAnime(Anime a){
        return a.getEpisodes() >= 10;
    }

    public List<Anime> filterRemovingNotAdult(List<Anime> list){
        return list.stream().filter(this::isLongAnime).collect(Collectors.toList());
    }
}
