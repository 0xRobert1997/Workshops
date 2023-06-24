package code.domain;

import lombok.*;

@Getter
@Setter
@ToString(of = {"servicePartId", "quantity"})
@EqualsAndHashCode(of = {"servicePartId"})
@Builder
@With
public class ServicePart {

    private Integer servicePartId;
    private Integer quantity;
    private CarServiceRequest carServiceRequest;
    private Part part;


}
