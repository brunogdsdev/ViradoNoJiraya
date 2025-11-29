package junitjava;

import crud.dominio.Anime;

public class JUnitMain {
    public static void main(String[] args) {
        Anime a = Anime.builder().name("naruto").episodes(20).build();


    }
}
