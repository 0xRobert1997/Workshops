package pl.zajavka.domain;

import lombok.*;

import java.math.BigDecimal;

@With
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

        private Long id;
        private String productCode;
        private String productName;
        private BigDecimal productPrice;
        private Boolean adultsOnly;
        private String description;
        private Producer producer;
}
