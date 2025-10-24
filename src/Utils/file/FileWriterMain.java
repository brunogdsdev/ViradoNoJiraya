package Utils.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {
    public static void main(String[] args) {

        File file = new File("file.txt");
            try(FileWriter fw = new FileWriter(file)) {
                fw.write("Hello World Java \n" +
                        "TESTE 123\n");
                fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
