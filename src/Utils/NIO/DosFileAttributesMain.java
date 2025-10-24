package Utils.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DosFileAttributesMain {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta/teste.txt");
        if(Files.notExists(path)){
            Path path1 = Files.createFile(path);
        }

        Files.setAttribute(path, "dos:hidden", true);
        Files.setAttribute(path, "dos:readonly", true); // tudo minusculo
    }
}
