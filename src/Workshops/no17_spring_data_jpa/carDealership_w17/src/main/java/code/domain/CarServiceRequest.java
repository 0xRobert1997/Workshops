package code.domain;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.Set;

@With
@Getter
@Setter
@Builder
@Value
@ToString(of = {"carServiceRequestId", "carServiceRequestNumber", "receivedDateTime", "completedDateTime", "customerComment"})
@EqualsAndHashCode(of = {"carServiceRequestId"})

public class CarServiceRequest {


    Integer carServiceRequestId;
    String carServiceRequestNumber;
    OffsetDateTime receivedDateTime;
    OffsetDateTime completedDateTime;
    String customerComment;
    Customer customer;
    CarToService car;
    Set<ServiceMechanic> serviceMechanics;
    Set<ServicePart> serviceParts;
}
