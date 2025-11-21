package Utils.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathMain {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("/media/bruno/Projetos/Estudos/Java/ViradoNoJiraya/pasta2/teste321.txt");
        System.out.println(p.getFileName().toFile());



        Path pasta = Paths.get("pasta"); // dir do projeto
        if(Files.notExists(pasta)){
            Path dir = Files.createDirectory(pasta);
        }

        Path sub = Paths.get("pasta/subpasta/subsub");
        Path subsub = Files.createDirectories(sub);

        Path file = Paths.get(sub.toString(), "file.txt");

        if(Files.notExists(file)){
            Files.createFile(file);
        }


        Path source = file;
        Path target = Paths.get(file.getParent().toString(), "file_renamed.txt");
//        Files.copy(source, target);
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
}
