package code.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(of = {"serviceMechanicId", "hours", "comment"})
@EqualsAndHashCode(of = {"serviceMechanicId"})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service_mechanic")
public class ServiceMechanicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_mechanic_id")
    private Integer serviceMechanicId;

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
