package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorMain {
    public static void main(String[] args) {
        List<Manga> lista = new ArrayList<>();

        lista.add(new Manga("naruto", 111L, 1, 100));
        lista.add(new Manga("one piece",221L,11, 22));
        lista.add(new Manga("dragon ball", 511L, 10, 0));

//         VAI DAR ERRO POIS NAO SE REMOVE EM UMA ITERACAO
//        for(Manga m : lista){
//            if(m.getQuantidade() == 0){
//                lista.remove(m);
//            }
//        }


//        Iterator<Manga> mangaInterator = lista.iterator();
//        while(mangaInterator.hasNext()){
//            if(mangaInterator.next().getQuantidade() == 0){
//                mangaInterator.remove();
//            }
//        }
//        System.out.println(lista);



        // a partir do java 8 tem o removeIf
        System.out.println("-------------------");

        lista.removeIf(manga -> manga.getQuantidade() == 0);
        System.out.println(lista);

    }
}
