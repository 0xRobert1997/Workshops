package Workshops.no2_functional_programming.Exercises.Project;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyConsumer {

    public void consumerConsumer(Consumer<String> c) {
        c.accept("arg");
    }

    public void consumerSupplier(Supplier<?> supplier) {
        System.out.println(supplier.get());
    }

    public void consumerFunction(Function<String, String> function) {
        System.out.println(function.apply("arg"));
    }
}
