package code.infrastructure.database.entity;

import code.infrastructure.database.entity.CarServiceRequestEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(of = {"carToServiceId", "vin", "brand", "model", "year"})
@EqualsAndHashCode(of ="carToServiceId")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_to_service")
public class CarToServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_to_service_id")
    private Integer carToServiceId;

    @Column(name = "vin", unique = true)
    private String vin;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private Set<CarServiceRequestEntity> carServiceRequests;

}
