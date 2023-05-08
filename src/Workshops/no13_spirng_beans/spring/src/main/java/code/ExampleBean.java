package code;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ExampleBean {

    // @Autowired musi być nad konstruktorem/setterem lub polem
    // jeśli jest tylko jeden konstruktor to adnotacja jest opcjonalna
    private final InjectedBean injectedBean;
    private final SomeCommonInterface nameByValue;


    // zamiast adnotacji @Qualifier można nazwać zmienną tak jak nazwa danego Beana
                                                // @Qualifier("nameByValue") SomeCommonInterface someCommonInterface
    public ExampleBean(InjectedBean injectedBean,  SomeCommonInterface nameByValue) {
        this.injectedBean = injectedBean;
        this.nameByValue = nameByValue;
        System.out.println("Callin constructor");
    }

    public void exampleMethod() {
        System.out.println("Calling exampleMethod");
    }
}
