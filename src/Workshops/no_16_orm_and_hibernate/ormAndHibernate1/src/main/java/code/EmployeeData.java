package code;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class EmployeeData {

    static Employee someEmployee1() {
        return Employee.builder()
                .name("Agnieszka")
                .surname("Pracownik")
                .salary(BigDecimal.TEN)
                .since(OffsetDateTime.of(2020, 1,1,1,1,0,0, ZoneOffset.UTC))
                .build();
    }

    static Employee someEmployee2() {
        return Employee.builder()
                .name("Stefan")
                .surname("Pracownik")
                .salary(BigDecimal.ONE)
                .since(OffsetDateTime.of(2021, 1,1,1,1,0,0, ZoneOffset.UTC))
                .build();
    }

    static Employee someEmployee3() {
        return Employee.builder()
                .name("Tomasz")
                .surname("Pracownik")
                .salary(new BigDecimal("123.45"))
                .since(OffsetDateTime.of(2022, 1,1,1,1,0,0, ZoneOffset.UTC))
                .build();
    }
}
