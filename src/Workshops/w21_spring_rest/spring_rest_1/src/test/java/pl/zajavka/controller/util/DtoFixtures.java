package pl.zajavka.controller.util;

import pl.zajavka.controller.dto.EmployeeDTO;
import pl.zajavka.controller.dto.PetDTO;
import pl.zajavka.infrastructure.database.entity.EmployeeEntity;

import java.math.BigDecimal;

public class DtoFixtures {

    public static EmployeeDTO someEmployee1() {
        return EmployeeDTO.builder()
                .name("aaa")
                .surname("bbb")
                .salary(BigDecimal.TEN)
                .phone("+21 321 321 321")
                .email("123@xd.pl")
                .build();
    }
    public static EmployeeDTO someEmployee2() {
        return EmployeeDTO.builder()
                .name("cccc")
                .surname("dddd")
                .salary(BigDecimal.TEN)
                .phone("+21 321 321 321")
                .email("123@xd.pl")
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
