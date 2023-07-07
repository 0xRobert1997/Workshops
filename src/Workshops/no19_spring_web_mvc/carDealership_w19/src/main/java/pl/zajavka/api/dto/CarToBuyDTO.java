package pl.zajavka.api.dto;

import pl.zajavka.domain.Invoice;

import java.math.BigDecimal;

public class CarToBuyDTO {

    String vin;
    String brand;
    String model;
    Integer year;
    String color;
    BigDecimal price;
}
