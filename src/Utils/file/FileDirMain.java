package Utils.file;

import java.io.File;
import java.io.IOException;

public class FileDirMain {
    public static void main(String[] args) {
        File dir = new File("folder");
        boolean is = dir.mkdir();
        System.out.println(is);

        File file = new File(dir.getAbsolutePath(),"teste.txt");
        //pasta criada
        boolean isCreated = false;
        try {
            isCreated = file.createNewFile();

            //arquivo renomeado
            boolean isRenamed =file.renameTo(new File(dir,"teste321.txt"));
            System.out.println(isRenamed);


            // renomear pata
            File renameDir = new File( "pasta2");
            boolean isDir = dir.renameTo(renameDir);

            System.out.println(isDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(isCreated);
    }
}
