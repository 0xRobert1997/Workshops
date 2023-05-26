package pl.zajavka.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

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

