package Workshops.no1_genercis_and_collections.advanced_collections.Exercises.ex1;

import java.util.List;
import java.util.Scanner;

public class ex3 {

    public static void main(String[] args) {

        List<String> commandList = List.of(
                "CEO: ADD INVOICE(19.20)",
                "CEO: ADD INVOICE(31.40)",
                "ACCOUNTANT: PROCESS INVOICE"
        );

        InvoiceStack invoiceStack = new InvoiceStack();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.printf("Please write a command or write thanks to end program: ");
            String input = scan.nextLine();
            if (input.equals("thanks")){
                break;
            }
            invoiceStack.processInput(input);
        }
    }
}
