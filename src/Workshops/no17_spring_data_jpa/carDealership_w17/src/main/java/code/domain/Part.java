package code.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@ToString(of = {"partId", "serialNumber", "description", "price"})
@EqualsAndHashCode(of = {"partId"})
@Builder
@With
public class Part {

    private Integer partId;

    private String serialNumber;
    private String description;
    private BigDecimal price;
    private Set<ServicePart> serviceParts;


}
