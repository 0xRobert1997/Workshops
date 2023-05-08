package code;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class InjectedBean {

    public InjectedBean() {
        System.out.println("Calling InjectedBean constructor");
    }

    public void someMethod() {
        System.out.println("callin someMethod()");
    }

    public void initMethod() {
        System.out.println("InjectedBean initMethod()");
    }
    public void destroyMethod() {
        System.out.println("InjectedBean destroyMethod()");
    }
}