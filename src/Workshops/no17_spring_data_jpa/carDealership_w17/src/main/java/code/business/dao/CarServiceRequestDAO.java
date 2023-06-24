package code.business.dao;

import code.domain.CarServiceRequest;

import java.util.Set;

public interface CarServiceRequestDAO {
    Set<CarServiceRequest> findActiveServiceRequestsByCarVin(String carVin);
}
