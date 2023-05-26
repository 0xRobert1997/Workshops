package pl.zajavka.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@With
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Purchase {

    private Long id;
    private Customer customer;
    private Product product;
    private Integer quantity;
    private OffsetDateTime dateTime;

}
