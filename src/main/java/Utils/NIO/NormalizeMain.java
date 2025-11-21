package Utils.NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeMain {
    public static void main(String[] args) {
        String dir = "home/bruno/dev";
        String arq = "../../arquivo.txt";


        Path p1 = Paths.get(dir, arq);
        System.out.println(p1.normalize());
    }
}
