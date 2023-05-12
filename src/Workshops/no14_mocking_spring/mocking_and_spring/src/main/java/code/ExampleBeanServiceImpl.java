package code;

public class ExampleBeanServiceImpl implements code.ExampleBeanService {

    private InjectedBeanService injectedBeanService;

    @Override
    public void setInjectedBeanService(InjectedBeanService injectedBeanService) {
        this.injectedBeanService = injectedBeanService;
    }

    @Override
    public String sampleMethod() {
        return injectedBeanService.anotherSampleMethod("smth");
    }
}
