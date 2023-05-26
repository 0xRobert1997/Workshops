package pl.zajavka.domain;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.Date;
@With
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

        private Long id;
        private String userName;
        private String email;
        private String name;
        private String surname;
        private OffsetDateTime dateOfBirth;
        private String telephoneNumber;
}


