package springExample;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InjectedBeanServiceImpl implements InjectedBeanService{
    @Override
    public boolean anotherSampleMethod() {
        System.out.println("InjectedBeanServiceImpl: anotherSampleMethod()");
        return false;
    }
}
