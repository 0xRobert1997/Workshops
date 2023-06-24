package code.domain;

import lombok.*;

@Getter
@Setter
@ToString(of = {"ServiceMechanicId", "hours", "comment"})
@EqualsAndHashCode(of = {"ServiceMechanicId"})
@Builder
@With
public class ServiceMechanic {

    private Integer ServiceMechanicId;
    private Integer hours;
    private String comment;
    private CarServiceRequest carServiceRequest;
    private Mechanic mechanic;
    private Service service;

}
