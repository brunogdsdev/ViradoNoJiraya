package Utils.NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeMain {

    public static void main(String[] args) {
        Path dir = Paths.get("/home/bruno");
        Path clazz = Paths.get("/home/bruno/java/viradonojiraya/OlaMundo.java");
        Path path = dir.relativize(clazz);
        System.out.println(path);

        Path abs1 = Paths.get("/home/bruno");
        Path abs2 = Paths.get("/usr/local");
        Path abs3 = Paths.get("/home/bruno/java/viradonojiraya/OlaMundo.java");
        Path rel1 = Paths.get("tmp");
        Path rel2 = Paths.get("tmp/tmp.2020");

        System.out.println("(1) -> "+ abs1.relativize(abs3));
        System.out.println("(2) -> "+ abs3.relativize(abs1));
        System.out.println("(3) -> "+ abs1.relativize(abs2));
        System.out.println("(4) -> "+ rel1.relativize(rel2));
        System.out.println("(5) -> "+ abs1.relativize(rel1)); // nao sabe onde fica o tmp
    }
}
