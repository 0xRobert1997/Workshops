package code;

import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

public class main {
    public static void main(String[] args) {

        // Dog burek = new Dog("Burek", 2, new Owner());
       // Dog kurek = Dog.of("kurek", 12, new Owner());


        Employee employee1 = Employee.builder()
                .name("Rob")
                .surname("pepega")
                .build();

        Employee employee2 = Employee.builder()
                .name("Rob")
                .adress("x321")
                .salary(BigDecimal.ZERO)
                .build();

        System.out.println(employee1);
        System.out.println(employee2);



    }
    @SneakyThrows
    public static void fileSize(Path path) {
        Files.size(path);
    }
}
