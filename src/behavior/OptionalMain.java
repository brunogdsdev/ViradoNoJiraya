package behavior;

import java.util.List;
import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {
        Optional<String> name = findName("Bruno");

        name.ifPresent(string -> System.out.println(string.toUpperCase()));
//        System.out.println(name.get().toString());
//        System.out.println(name.toString());
    }

    private static Optional<String> findName(String name){
        List<String> list = List.of("Bruno", "Gomes");
        int i = list.indexOf(name);

        if(i != -1){
            return Optional.ofNullable(list.get(i));
        }
        return Optional.empty();
    }
}
