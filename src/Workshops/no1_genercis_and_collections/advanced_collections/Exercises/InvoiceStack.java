package Workshops.no1_genercis_and_collections.advanced_collections.Exercises;

import Workshops.no1_genercis_and_collections.advanced_collections.Exercises.Invoice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;

public class InvoiceStack {

    private Integer counter = 1;

    private Deque<Invoice> invoiceStack = new ArrayDeque<>();

    public void processInput(String command) {
        if (command.contains("CEO: ADD INVOICE(")) {
            processCEOInput(command);
        } else if (command.contains("ACCOUNTANT: PROCESS INVOICE")) {
            processAccountantInput(command);
        } else {
            System.out.println("O co chodzi?");
        }
    }

    private void processCEOInput(String command) {
        BigDecimal amount = new BigDecimal(command.substring(command.indexOf("(") + 1, command.indexOf(")")));
        Integer year = LocalDate.now().getYear();
        String id = counter + "/" + year;
        counter++;

        Invoice invoice = new Invoice(id, amount);
        invoiceStack.push(invoice);

        System.out.printf("%n%s%n", command);
        System.out.printf("CEO added invoice: ID: %s, amount: %s%n", id, amount);
        System.out.printf("Current invoices amount: %s. Invoices: %s%n", getInvociesSum(), invoiceStack);
    }

    private  void processAccountantInput(String command) {
        if (invoiceStack.size() != 0) {
            Invoice invoice = invoiceStack.pop();
            System.out.printf("%n$s$n", command);
            System.out.printf("ACCOUNTANT processed invoice: %s%n", invoice);
            System.out.printf("Current invoices amount: %s. Invoices: %s%n", getInvociesSum(),invoiceStack);
        } else {
            throw new RuntimeException("Sorry but there is no invoice to process!");
        }

    }

    private BigDecimal getInvociesSum() {
        BigDecimal sum = BigDecimal.ZERO;

        for (Invoice invoice : invoiceStack) {
            sum = sum.add(invoice.getAmount());
        }
        return sum;
    }
}
