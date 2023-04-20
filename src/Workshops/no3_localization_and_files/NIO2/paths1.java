package Workshops.no3_localization_and_files.NIO2;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;

public class paths1 {
    // Uniform Resource Identifier
    public static void main(String[] args) {
        Path path1 = Paths.get("src/Workshops/myFile.txt");
        System.out.println(path1);
        System.out.println(Files.exists(path1));

        try {
            Path path2 = Paths.get(new URI("file://src/Workshops/myFile.txt"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        FileSystem fileSystem = FileSystems.getDefault();
        System.out.println(fileSystem);


        File file1 = new File("someFile.txt");
        Path path3 = file1.toPath();

        Path path2 = Paths.get("someFile.txt");
        File file = path2.toFile();



    }
}
