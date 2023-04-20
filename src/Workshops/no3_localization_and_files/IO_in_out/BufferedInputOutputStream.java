package Workshops.no3_localization_and_files.IO_in_out;

import java.io.*;
import java.util.Arrays;

public class BufferedInputOutputStream {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/Workshops/someFileInput.txt");
        File outputFile = new File("src/Workshops/someFileOutput.txt");
        System.out.println(inputFile.exists());

        justCopyWithBuffer(inputFile, outputFile);
    }

    private static void justCopyWithBuffer(File inputFile, File outputFile) throws IOException {
        try (
                InputStream input = new BufferedInputStream(new FileInputStream(inputFile));
                OutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile));
        ) {
            byte[] buffer = new byte[8];
            int lenght = input.read(buffer);
            System.out.printf("Start reading file: [%s]%n", inputFile);
            System.out.printf("Reading buffered values: [%s], chars[%s], length: [%s]%n", byteArrToString(buffer), toCharString(buffer), lenght);

            while (lenght > 0) {
                System.out.printf("Writing buffered values: [%s], chars: [%s]%n", byteArrToString(buffer), toCharString(buffer));

                output.write(buffer, 0, lenght);
                output.flush();

                lenght = input.read(buffer);
                System.out.printf("Reading value: [%s], char[%s]%n", byteArrToString(buffer), toCharString(buffer));
            }
        }
    }

    static String toCharString(byte[] input) {
        char[] charArray = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            charArray[i] = (char) input[i];
        }
        return replaceNewLines(Arrays.toString(charArray));
    }

    static String byteArrToString(byte[] input) {
        return replaceNewLines(Arrays.toString(input));
    }

    private static String replaceNewLines(String input) {
        return input.replace("\n", "\\n").replace("\r", "\\r");
    }


}
