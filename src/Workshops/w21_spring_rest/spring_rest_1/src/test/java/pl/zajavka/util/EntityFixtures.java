package pl.zajavka.util;

import pl.zajavka.infrastructure.database.entity.EmployeeEntity;

import java.math.BigDecimal;

public class EntityFixtures {

    public static EmployeeEntity someEmployee1() {
        return EmployeeEntity.builder()
                .name("aaa")
                .surname("bbb")
                .salary(BigDecimal.TEN)
                .phone("+48 123 123 123")
                .email("123@xd.pl")
                .build();
    }
    public static EmployeeEntity someEmployee2() {
        return EmployeeEntity.builder()
                .name("bbb")
                .surname("ccc")
                .salary(BigDecimal.TEN)
                .phone("+48 123 123 123")
                .email("123@xd.pl")
                .build();
    }
    public static EmployeeEntity someEmployee3() {
        return EmployeeEntity.builder()
                .name("ccc")
                .surname("ddd")
                .salary(BigDecimal.TEN)
                .phone("+48 123 123 123")
                .email("123@xd.pl")
                .build();
    }
}
