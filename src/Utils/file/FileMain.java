package Utils.file;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;

public class FileMain {
    public static void main(String[] args) {
        try{
            File file = new File("file.txt");
            boolean isCreated = file.createNewFile();
            System.out.println("isCreated: "+isCreated);

            System.out.println("path:"+ file.getPath());
            System.out.println("path abs:"+ file.getAbsolutePath());
            System.out.println("isDirectory:"+ file.isDirectory());
            System.out.println("isHidden:"+ file.isHidden());
            System.out.println("isFile:"+ file.isFile());
            System.out.println("lastModified:"+ Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()).toLocalDateTime());
            if(file.exists()){
                boolean isDeleted = file.delete();
                System.out.println("isDeleted"+isDeleted);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
