package code.business.dao;

import code.domain.CarToBuy;

import java.util.Optional;

public interface CarToBuyDAO {
    Optional<CarToBuy> findCarToBuyByVin(String vin);
}
