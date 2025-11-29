package junitjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MangaTest {
    private Manga manga1;
    private Manga manga2;

    @BeforeEach
    void setUp() {
        manga1 = new Manga("Naruto", 500);
        manga2 = new Manga("Boruto", 200);

    }


    @Test
    @DisplayName("Verifica se os metodos acessores estao retornando.")
    void accessors_ReturnData(){
        Assertions.assertEquals("Naruto", manga1.name());
        Assertions.assertEquals(500, manga1.episodes());
    }

    @Test
    @DisplayName("Retorna true quando Manga é record")
    void isRecord(){
        Assertions.assertTrue(Manga.class.isRecord());
    }
}