package code;

import org.springframework.stereotype.Service;

@Service
public class InjectedBean {


    public InjectedBean() {
        System.out.println("Calling InjectedBean constructor");
    }

    public void someMethod() {
        System.out.println("callin someMethod()");
    }
}