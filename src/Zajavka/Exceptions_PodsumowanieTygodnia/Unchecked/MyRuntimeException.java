package Zajavka.Exceptions_PodsumowanieTygodnia.Unchecked;

public class MyRuntimeException extends RuntimeException{

    public MyRuntimeException() {
    }

    public MyRuntimeException(String message) {
        super(message);
    }

    public MyRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
