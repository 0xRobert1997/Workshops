package code.business.dao;

import code.infrastructure.database.entity.CarHistoryEntity;
import code.infrastructure.database.entity.CarToBuyEntity;
import code.infrastructure.database.entity.CarToServiceEntity;

import java.util.Optional;

public interface CarDAO {

    Optional<CarToBuyEntity> findCarToBuyByVin(String vin);

    Optional<CarToServiceEntity> findCarToServiceByVin(String vin);

    CarToServiceEntity saveCarToService(CarToServiceEntity entity);

    CarHistoryEntity findCarHistoryByVin(String vin);
}
