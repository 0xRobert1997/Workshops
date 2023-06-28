package code;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InvoiceNameGenerator {
    private static final String INVOICE_NAME_PATTERN = "FV_";
    private Lock lockExample = new ReentrantLock();
    private int lastInvoiceNumber = 0;
    public String generateNewInvoiceName() {
/*        synchronized (this){
            //something
        }*/
        lockExample.lock();
        int calculatedLastInvoiceNumber = lastInvoiceNumber + 1;
        // sami musimy pamiętać o zdjęciu locka
        lockExample.unlock();
        return INVOICE_NAME_PATTERN + calculatedLastInvoiceNumber;
    }
}

