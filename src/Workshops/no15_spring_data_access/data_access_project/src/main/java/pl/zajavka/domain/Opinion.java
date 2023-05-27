package pl.zajavka.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@With
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Opinion{
    private Long id;
    private Customer customer;
    private Product product;
    private Integer stars;
    private String comment;
    private OffsetDateTime dateTime;

}

