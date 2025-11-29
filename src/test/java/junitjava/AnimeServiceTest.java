package junitjava;

import crud.dominio.Anime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimeServiceTest {
    private Anime longAnime;
    private Anime shortAnime;
    AnimeService service;
    @BeforeEach
    public void setUp(){
        service = new AnimeService();
        longAnime = Anime.builder().name("naruto").episodes(20).build();
        shortAnime = Anime.builder().name("naruto").episodes(10).build();
    }


    @Test
    @DisplayName("É menor que 10?")
    void isShortAnime_ReturnFalse_WhenEpisodesIsLowerThan10() {
        Assertions.assertEquals(false, service.isShortAnime(shortAnime));
//        Assertions.assertFalse(service.isShortAnime(a));
    }

    @Test
    @DisplayName("É maior que 10?")
    void isLongAnime_ReturnTrue_WhenEpisodesIsUpperThan10(){
        Assertions.assertEquals(true, service.isLongAnime(longAnime));
//        Assertions.assertTrue(service.isShortAnime(a));
    }


    @Test
    @DisplayName("Dá erro com nullPointerException?")
    void isShortAnime_CantBeNull(){
        Assertions.assertThrows(NullPointerException.class, () -> service.isShortAnime(null));
    }

    @Test
    @DisplayName("Should return list with only longs")
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed() {
        Anime a1 = Anime.builder().episodes(7).build();
        Anime a2 = Anime.builder().episodes(18).build();
        Anime a3 = Anime.builder().episodes(21).build();

        List<Anime> personList = List.of(a1, a2, a3);
        Assertions.assertEquals(2, service.filterRemovingNotAdult(personList).size());
    }

}