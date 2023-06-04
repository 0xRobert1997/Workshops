package code.manyToMany;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class ExampleData {

    static Employee someEmployee1() {
        return Employee.builder()
                .name("Aga")
                .surname("Pepega")
                .salary(new BigDecimal("123"))
                .since(OffsetDateTime.of(2001, 11, 9, 11, 11, 0,0, ZoneOffset.UTC))
                .build();
    }

    static Employee someEmployee2() {
        return Employee.builder()
                .name("Wojtek")
                .surname("Pepega")
                .salary(new BigDecimal("123"))
                .since(OffsetDateTime.of(2002, 11, 9, 11, 11, 0,0, ZoneOffset.UTC))
                .build();
    }

    static Employee someEmployee3() {
        return Employee.builder()
                .name("Maksio")
                .surname("Pepega")
                .salary(new BigDecimal("666"))
                .since(OffsetDateTime.of(2003, 11, 9, 11, 11, 0,0, ZoneOffset.UTC))
                .build();
    }

    static Project someProject1() {
        return Project.builder()
                .name("one")
                .description("Kappa")
                .deadline(OffsetDateTime.of(2001, 11, 9, 11, 11, 0,0, ZoneOffset.UTC))
                .build();
    }
    static Project someProject2() {
        return Project.builder()
                .name("two")
                .description("Kappa")
                .deadline(OffsetDateTime.of(2002, 11, 9, 11, 11, 0,0, ZoneOffset.UTC))
                .build();
    }
    static Project someProject3() {
        return Project.builder()
                .name("three")
                .description("Kappa")
                .deadline(OffsetDateTime.of(2003, 11, 9, 11, 11, 0,0, ZoneOffset.UTC))
                .build();
    }
}
