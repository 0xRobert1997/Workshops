package Workshops.no2_functional_programming.Exercises.Project;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class main {

    public static void main(String[] args) {

        Supplier<String> supplierImp = () -> "suppling";
        Consumer<Integer> consumerImp = a -> System.out.println("consuming: " + a);
        Function<Integer, String> functionImp = a -> "returning as string: " + a;


        Producer<Integer, String> myProducer = new Producer<>();

        Supplier<Integer> mySupplier = myProducer.supplierImp(2);
        mySupplier.get();
        myProducer.consumerImp();
        myProducer.functionImp(2, "test");

        Transformer.functionImp();
        Transformer.unaryImp();

        Function<String, String> myFunction = Transformer.functionImp();
        Optional<String> myOptional = Optional.of("myString").map(myFunction);

    }
}
