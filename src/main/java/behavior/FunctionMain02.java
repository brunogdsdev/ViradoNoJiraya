package behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionMain02 {

    public static void main(String[] args) {

        List<String> list = List.of("teste", "foo", "baz");
        List<Integer> mapped = map(list, s -> s.length());

        System.out.println(mapped);

    }


    private static <T,R> List<R> map(List<T> list, Function<T,R> function){
        List<R> result = new ArrayList<>();

        for(T e : list){
            R r = function.apply(e);
            result.add(r);
        }

        return result;
    }
}
