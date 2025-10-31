package collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(); // LinkedHashMap mantem a ordem, o HashMap ordena pelo value
        map.put("b", "bteste");
        map.put("vc", "voce");
        map.put("a", "ateste");

        map.put("mouze", "mouse");
        map.put("teklado", "teclado");
        map.put("vc", "voce2");
        map.putIfAbsent("vc", "voce3"); // apenas insere se nao existir

        System.out.println(map);

        for(String key: map.keySet()){
            System.out.println(key +" => "+ map.get(key));
        }

        System.out.println("===============================");

        for(String val : map.values()){
            System.out.println(val);
        }

        System.out.println("===============================");

        for(Map.Entry<String, String> val : map.entrySet()){
            System.out.println(val.getKey()+ " ===> "+ val.getValue());
        }
    }
}
