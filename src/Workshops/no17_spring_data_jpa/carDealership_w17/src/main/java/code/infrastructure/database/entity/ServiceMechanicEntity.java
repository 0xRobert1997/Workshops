package code.infrastructure.database.entity;

import code.infrastructure.database.entity.CarServiceRequestEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(of = {"ServiceMechanicId", "hours", "comment"})
@EqualsAndHashCode(of = {"ServiceMechanicId"})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service_mechanic")
public class ServiceMechanicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_mechanic_id")
    private Integer ServiceMechanicId;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_service_request_id")
    private CarServiceRequestEntity carServiceRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mechanic_id")
    private MechanicEntity mechanic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

}
