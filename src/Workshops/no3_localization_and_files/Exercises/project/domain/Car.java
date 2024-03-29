package Workshops.no3_localization_and_files.Exercises.project.domain;

import java.math.BigDecimal;

public class Car {

    private String color;
    private String vin;
    private String company;
    private String model;
    private String modelYear;
    private BigDecimal price;

    public Car(String color, String vin, String company, String model, String modelYear, BigDecimal price) {
        this.color = color;
        this.vin = vin;
        this.company = company;
        this.model = model;
        this.modelYear = modelYear;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public String getVin() {
        return vin;
    }

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public String getModelYear() {
        return modelYear;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", vin='" + vin + '\'' +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", modelYear='" + modelYear + '\'' +
                ", price=" + price +
                '}';
    }
}
