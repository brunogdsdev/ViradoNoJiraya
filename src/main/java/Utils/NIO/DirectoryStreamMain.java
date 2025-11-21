package Utils.NIO;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamMain {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for(Path p: stream ){
                System.out.println(p.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();        }
    }
}
