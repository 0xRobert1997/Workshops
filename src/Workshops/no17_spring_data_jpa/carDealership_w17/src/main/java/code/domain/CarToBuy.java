package code.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString(of = {"carToBuyId", "vin", "brand", "model", "color", "year"})
@EqualsAndHashCode(of = "carToBuyId")
@With
@Builder
public class CarToBuy {

    Integer carToBuyId;
    String vin;
    String brand;
    String model;
    Integer year;
    String color;
    BigDecimal price;
    Invoice invoice;

}
