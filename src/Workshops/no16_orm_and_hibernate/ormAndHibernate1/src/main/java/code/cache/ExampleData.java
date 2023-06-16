package code.cache;


import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class ExampleData {

    static CachedEmployee someEmployee1() {
        return CachedEmployee.builder()
                .name("Aga")
                .surname("Pepega")
                .salary(new BigDecimal("123"))
                .since(OffsetDateTime.of(2001, 11, 9, 11, 11, 0,0, ZoneOffset.UTC))
                .build();
    }

    static CachedEmployee someEmployee2() {
        return CachedEmployee.builder()
                .name("Wojtek")
                .surname("Pepega")
                .salary(new BigDecimal("123"))
                .since(OffsetDateTime.of(2002, 11, 9, 11, 11, 0,0, ZoneOffset.UTC))
                .build();
    }

    static CachedEmployee someEmployee3() {
        return CachedEmployee.builder()
                .name("Maksio")
                .surname("Pepega")
                .salary(new BigDecimal("666"))
                .since(OffsetDateTime.of(2003, 11, 9, 11, 11, 0,0, ZoneOffset.UTC))
                .build();
    }
}
