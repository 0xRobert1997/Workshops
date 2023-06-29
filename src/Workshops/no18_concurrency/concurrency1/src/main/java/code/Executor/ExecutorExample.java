package code.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

        // .execute() przyjmuje Runnable który ma metodę run()

        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            executorService
                    .execute(() -> System.out.println("Pierwsze zadanie z użyciem ExecutorService"));
            executorService
                    .execute(() -> System.out.println("... i drugie"));
        } finally {
            if(executorService != null) {
                executorService.shutdown();
            }
        }
    }

    // Future<?> submit(Runnable runnable)
    // zwraca generyki Future dzięki temu możemy śledzić postęp zadania
}
