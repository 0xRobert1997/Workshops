package code;

import java.util.concurrent.locks.ReentrantLock;

public class FairnessExample {

    private final ReentrantLock reentrantLock = new ReentrantLock(true);
    public void fairNotSynchronizedMethod() {
        reentrantLock.lock();
        try {
// critical section kodu
        } finally {
            reentrantLock.unlock(); // nie zapomnij zwolnić na koniec
        }
    }
}
