package code.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@ToString(of = {"serviceId", "serviceCode", "description", "price"})
@EqualsAndHashCode(of = {"serviceId"})
@Builder
@With
public class Service {


    private Integer serviceId;

    private String serviceCode;

    private String description;

    private BigDecimal price;

    private Set<ServiceMechanic> serviceMechanics;
}
