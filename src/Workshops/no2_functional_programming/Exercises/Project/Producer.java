package Workshops.no2_functional_programming.Exercises.Project;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Producer<T, R>{


    public Supplier<T> supplierImp(T t) {
        return () -> t;
    }

    public Consumer<T> consumerImp(){
        return (T a) -> System.out.println("consuming: " + a);
    }

    public Function<T, R> functionImp(T t, R r) {
        return a -> r;
    }

}
