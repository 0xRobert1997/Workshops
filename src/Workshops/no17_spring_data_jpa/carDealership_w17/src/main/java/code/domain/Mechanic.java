package code.domain;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(of = {"mechanicId", "name", "surname", "pesel"})
@EqualsAndHashCode(of = {"mechanicId"})
@With
@Builder
public class Mechanic {

    private Integer mechanicId;
    private String name;
    private String surname;
    private String pesel;
    private Set<ServiceMechanic> serviceMechanics;
}
