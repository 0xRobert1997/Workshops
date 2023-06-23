package code.infrastructure.database.entity;

import code.infrastructure.database.entity.CarServiceRequestEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(of = {"servicePartId", "quantity"})
@EqualsAndHashCode(of = {"servicePartId"})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service_part")
public class ServicePartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_part_id")
    private Integer servicePartId;

    @Column(name = "quantity")
    private Integer quantity;


    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "car_service_request_id")
    private CarServiceRequestEntity carServiceRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="part_id")
    private PartEntity part;


}
