package Utils.NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveMain {

    public static void main(String[] args) {
        Path dir = Paths.get("home/bruno");
        Path arquivo = Paths.get("dev/arquivo.txt");
        Path resolve = dir.resolve(arquivo);

        System.out.println("resolve"+ resolve);


        Path abs = Paths.get("/home/bruno");
        Path rel = Paths.get("dev");
        Path file = Paths.get("arquivo.txt");

        System.out.println("(1) -> "+ abs.resolve(rel));
        System.out.println("(2) -> "+ abs.resolve(file));
        System.out.println("(3) -> "+ rel.resolve(abs));
        System.out.println("(4) -> "+ rel.resolve(file));
        System.out.println("(5) -> "+ file.resolve(abs));
        System.out.println("(6) -> "+ file.resolve(rel));
    }
}
