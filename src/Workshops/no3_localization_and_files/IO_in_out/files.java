package Workshops.no3_localization_and_files.IO_in_out;

import java.io.File;
import java.io.IOException;

public class files {

    public static void main(String[] args) {

        File file1 = new File("./src/Workshops/someFileInput.txt");
        System.out.println(file1.exists());
        System.out.println("file1: " + file1);
        System.out.println("AbsolutePath: " + file1.getAbsolutePath());
        System.out.println("AbsoluteFile: " + file1.getAbsoluteFile());
        System.out.println("UsuableSpace: " + file1.getUsableSpace());
        System.out.println("Parent: " + file1.getParent());

        // rename przyjmuje file
        file1.renameTo(new File("kekw.txt"));
       // file1.delete();


        File myFile = new File("nosrc/example/code.txt");
        System.out.println(myFile.mkdir());
        // zrobi folder o nazwie code.txt
        // mkdirs tworzy wszystkie foldery po drodze
        System.out.println(myFile.mkdirs());
        File myFile2 = new File("zajav2.txt");
        try {
            System.out.println(myFile2.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
