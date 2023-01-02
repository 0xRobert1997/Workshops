package Workshops.no3_localization_and_files.IO_in_out;

import java.util.Scanner;

public class scanner {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter some data: ");

        while(myScanner.hasNext()) {
            String line = myScanner.nextLine();
            System.out.println("Entered: " + line);

            if (line.equals("done")) {
                break;
            }
        }
    }
}
