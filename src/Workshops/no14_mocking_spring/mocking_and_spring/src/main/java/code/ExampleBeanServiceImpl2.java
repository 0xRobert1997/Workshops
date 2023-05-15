package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleBeanServiceImpl2 implements ExampleBeanService2{
    private List<String> sampleList = new ArrayList<>();

    @Override
    public void sampleMethod(String... valuesToAdd) {
        for (String s : valuesToAdd) {
            sampleList.add(s);
        }

    }
}
