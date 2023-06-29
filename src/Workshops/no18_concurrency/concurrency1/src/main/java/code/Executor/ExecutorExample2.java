package code.Executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample2 {

    public static void main(String[] args) {

        final String TEST_STRING = "Mój kod jest bezbłędny";
        final String NEW_STRING = "czasami ";
        ExecutorService executorService = null;

        try {
            StringBuilder stringBuilder = new StringBuilder(TEST_STRING);
            executorService = Executors.newSingleThreadExecutor();

            System.out.println("Tutaj rozpoczynam");

            Future<StringBuilder> expectedResult = executorService
                    .submit(() -> stringBuilder.replace(13, 16, NEW_STRING));

            printValueWhenReady(expectedResult);
        } catch (ExecutionException | InterruptedException exception) {
            // obsługa wyjątku
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }
    // metoda submit() jest wykonywana w innym wątku, a wątek main jedzie dalej i wywołuje printValueWhenReady
    // a w pętli printuje się Czekan an wykonania zadania do momentu aż tamten wątek skończy robic swoje
    private static void printValueWhenReady(Future<StringBuilder> stringBuilderFuture) throws ExecutionException, InterruptedException {
        while (!stringBuilderFuture.isDone()) {
            System.out.println("Czekam na wykonanie zadania!");
        }
        System.out.println(stringBuilderFuture.get().toString());
    }
}
