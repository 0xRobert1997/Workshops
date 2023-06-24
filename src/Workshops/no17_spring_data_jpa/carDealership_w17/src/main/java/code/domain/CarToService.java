package code.domain;

import lombok.*;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString(of = {"carToServiceId", "vin", "brand", "model", "year"})
@EqualsAndHashCode(of = "carToServiceId")
@Builder
@With
public class CarToService {

    Integer carToServiceId;
    String vin;
    String brand;
    String model;
    Integer year;
    Set<CarServiceRequest> carServiceRequests;

    public boolean wasCarBoughtHere() {
        return Objects.nonNull(vin)
                && Objects.isNull(model)
                && Objects.isNull(year)
                && Objects.isNull(brand);
    }
}
