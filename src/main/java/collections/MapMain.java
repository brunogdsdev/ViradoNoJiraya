package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class MapMain {
    public static void main(String[] args) {

        Consumidor consumidor = new Consumidor("Bruno");
        Consumidor consumidor2 = new Consumidor("BrunoGomes");


        Manga manga1 = new Manga("pokemon", 21L, 14, 20);
        Manga manga2 = new Manga("digimon", 2L, 4, 2);
        Manga manga3 = new Manga("naruto", 111L, 1, 100);
        Manga manga4 = new Manga("one piece",221L,11, 22);
        Manga manga5 = new Manga("dragon ball", 511L, 10, 0);

        Map<Consumidor, Manga> banca = new HashMap<>();
        banca.put(consumidor, manga1);
        banca.put(consumidor2, manga3);

        for(Map.Entry<Consumidor, Manga> entry : banca.entrySet()){
            System.out.println(entry.getKey()+ " ==> "+ entry.getValue().getNome());
        }

    }
}

class Consumidor{
    private Long id;
    private String nome;

    public Consumidor(String nome) {
        this.id = ThreadLocalRandom.current().nextLong(0, 100_000);
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Consumidor that = (Consumidor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Consumidor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
