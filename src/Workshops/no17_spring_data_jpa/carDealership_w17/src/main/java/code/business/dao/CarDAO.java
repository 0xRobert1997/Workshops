package code.business.dao;

import code.domain.CarHistory;
import code.domain.CarToBuy;
import code.domain.CarToService;

import java.util.Optional;

public interface CarDAO {

    Optional<CarToBuy> findCarToBuyByVin(String vin);

    Optional<CarToService> findCarToServiceByVin(String vin);

    CarToService saveCarToService(CarToService car);

    CarHistory findCarHistoryByVin(String vin);
}
