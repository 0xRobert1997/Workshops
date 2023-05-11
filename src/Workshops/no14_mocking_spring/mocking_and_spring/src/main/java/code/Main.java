package code;

// ctrl + shift + t - skrót to tworzenia klasy z testem

public class Main {
    public static void main(String[] args) {

        code.InjectedBeanServiceImpl injectedBeanService = new code.InjectedBeanServiceImpl();
        code.ExampleBeanService exampleBeanService = new code.ExampleBeanServiceImpl();
        exampleBeanService.setInjectedBeanService(injectedBeanService);

        System.out.println(exampleBeanService.sampleMethod());
    }
}
