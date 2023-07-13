package pl.zajavka.util;

import lombok.experimental.UtilityClass;
import pl.zajavka.infrastructure.database.entity.EmployeeEntity;

import java.math.BigDecimal;

@UtilityClass
public class EntityFixtures {
    public static EmployeeEntity someEmployee1() {
        return EmployeeEntity.builder()
                .name("Agnieszka")
                .surname("Zajavkowa")
                .salary(new BigDecimal("12345"))
                .phone("+48 555 555 555")
                .email("zajavka@zajavka.com")
                .build();
    }
    public static EmployeeEntity someEmployee2() {
        return EmployeeEntity.builder()
                .name("Remek")
                .surname("Spring")
                .salary(new BigDecimal("321"))
                .phone("+60 111 111 111")
                .email("remek@xd.com")
                .build();
    }
    public static EmployeeEntity someEmployee3() {
        return EmployeeEntity.builder()
                .name("Tadek")
                .surname("Pepega")
                .salary(new BigDecimal("10000"))
                .phone("+11 222 222 222")
                .email("something@something.com")
                .build();
    }
}
