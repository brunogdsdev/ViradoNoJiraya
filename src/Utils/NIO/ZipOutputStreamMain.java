package Utils.NIO;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamMain {
    public static void main(String[] args) {
        Path p = Paths.get("pasta/arq.zip");
        Path arq = Paths.get("pasta/subpasta/subsub");
        zip(p,arq);
    }

    private static void zip(Path arquivoZip, Path arquivoParaZipar){
        try(ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
            DirectoryStream<Path> dir = Files.newDirectoryStream(arquivoParaZipar)){

            for(Path file : dir){
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                zipStream.putNextEntry(zipEntry);
                Files.copy(file, zipStream);
                zipStream.closeEntry();
            }

            System.out.println("ZIP CRIADO COM SUCESSO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
