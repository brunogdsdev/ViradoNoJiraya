package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ListSortMain {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>();

        mangas.add("Naruto");
        mangas.add("pokemon");
        mangas.add("Dragon ball");

        Collections.sort(mangas);
        for(String manga : mangas){
            System.out.println(manga);
        }


        List<Integer> numeros = new ArrayList<>();
        numeros.add(110);
        numeros.add(2100);
        numeros.add(10);
        numeros.add(21);

        System.out.println(numeros);
        Collections.sort(numeros);

        System.out.println(numeros);

        List<Manga> lista = new ArrayList<>();

        lista.add(new Manga("naruto", 111L, 1));
        lista.add(new Manga("one piece",221L,11));
        lista.add(new Manga("dragon ball", 11L, 10));


        for(Manga m :  lista){
            System.out.println(m);
        }
        System.out.println("------------ ordenar ------");
        Collections.sort(lista);

        for(Manga m :  lista){
            System.out.println(m);
        }

    }
}


class Manga implements Comparable<Manga>{
    private String nome;
    private Long id;
    private double preco;

    public int compareTo(Manga manga){
//        !ORDENAR POR PRECO QUE É UM TIPO PRIMITIVO double

//        if(this.preco < manga.getPreco()) return -1;
//        if(this.preco == manga.getPreco()) return 0;
//        return 1;

//        !OU ENTAO usando o wrapper Double pra comprar o tipo primitivo double
//            return Double.compare(preco, manga.getPreco());

//        !OU ENTAO DESSA FORMA MAIS FACIL, COMO O ID LONG JÁ É UM WRAPPER....
//        return this.id.compareTo(manga.getId());
//

        return this.nome.compareTo(manga.getNome());
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return id == manga.id && Double.compare(preco, manga.preco) == 0 && Objects.equals(nome, manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, id, preco);
    }

    @Override
    public String toString() {
        return "Manga{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", preco=" + preco +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Manga(String nome, long id, double preco) {
        Objects.requireNonNull(id, "Id nao pode ser null");
        Objects.requireNonNull(nome, "Nome nao pode ser null");
        Objects.requireNonNull(preco, "Preco nao pode ser null");

        this.nome = nome;
        this.id = id;
        this.preco = preco;
    }
}
