package code.business.dao;

import code.domain.CarToBuy;
import code.domain.CarToService;

import java.util.Optional;

public interface CarToBuyDAO {
    Optional<CarToBuy> findCarToBuyByVin(String vin);
}
