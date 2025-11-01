package behavior;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerLambdaMain {
    public static void main(String[] args) {
        List<String> strings = List.of("Bruno", "Test", "1234");

        List<Integer> integers = List.of(1, 2, 34, 5, 5, 6, 7);
        forEach(strings, s -> System.out.println(s));
        forEach(integers, i -> System.out.print(i));
    }


    private static <T> void forEach(List<T> list, Consumer<T> consumer){
        for (T t : list) {
            consumer.accept(t);
        }

    }
}
