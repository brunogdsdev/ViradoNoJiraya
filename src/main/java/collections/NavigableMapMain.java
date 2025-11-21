package collections;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapMain {
    public static void main(String[] args) {
        NavigableMap<String, String> map = new TreeMap<>();


        Manga dragonBall = new Manga("dragon ball", 511L, 10, 0);

        map.put("A", "Letra A");
        map.put("B", "Letra B");
        map.put("C", "Letra C");
        map.put("D", "Letra D");
        map.put("E", "Letra E");

        for(Map.Entry<String, String> m : map.entrySet()){
            System.out.println(m.getKey()+ " ==> "+ m.getValue());
        }


        // lower <
        // floor <=
        // higher >
        // ceiling >=
        System.out.println(map.headMap("C", true));
        System.out.println(map.ceilingKey("C"));
        System.out.println(map.higherKey("C"));
        System.out.println(map.lowerKey("C"));
        System.out.println(map.floorKey("C"));
    }
}
