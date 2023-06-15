package code.business.dao;

import code.infrastructure.database.entity.CarServiceRequestEntity;

import java.util.Set;

public interface CarServiceRequestDAO {
    Set<CarServiceRequestEntity> findActiveServiceRequestsByCarVin(String carVin);
}
