package code.business.dao;

import code.domain.CarHistory;
import code.domain.CarToService;

import java.util.Optional;

public interface CarToServiceDAO {


    Optional<CarToService> findCarToServiceByVin(String vin);

    CarToService saveCarToService(CarToService car);

    CarHistory findCarHistoryByVin(String vin);
}
