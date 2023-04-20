package Workshops.no2_functional_programming.Exercises.Project;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Transformer<T, R> {



    public static <T> Function<T, T> functionImp() {
        return (T t) -> t;
    }

    public static <T> UnaryOperator<T> unaryImp() {
        return (T t) -> t;
    }

}
