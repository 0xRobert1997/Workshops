package pl.zajavka.util;

import pl.zajavka.controller.dto.EmployeeDTO;
import pl.zajavka.controller.dto.PetDTO;
import pl.zajavka.infrastructure.database.entity.EmployeeEntity;

import java.math.BigDecimal;

public class DtoFixtures {

    public static EmployeeDTO someEmployee1() {
        return EmployeeDTO.builder()
                .name("Stefan")
                .surname("Zajavka")
                .salary(new BigDecimal("52322.00"))
                .phone("+48 666 666 666")
                .email("one@zajavka.pl")
                .build();
    }
    public static EmployeeDTO someEmployee2() {
        return EmployeeDTO.builder()
                .name("Agnieszka")
                .surname("Spring")
                .salary(new BigDecimal("62341.00"))
                .phone("+48 666 420 666")
                .email("two@zajavka.pl")
                .build();
    }

    public static PetDTO somePet() {
        return PetDTO.builder()
                .petId(1)
                .petStorePetId(4L)
                .name("lion")
                .category("deadly")
                .build();
    }
}
