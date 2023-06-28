package code.infrastructure.database.repository;

import code.business.dao.CarToBuyDAO;
import code.domain.CarToBuy;
import code.infrastructure.database.repository.jpa.CarToBuyJpaRepository;
import code.infrastructure.database.repository.mapper.CarToBuyEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CarToBuyRepository implements CarToBuyDAO {

    private final CarToBuyJpaRepository carToBuyJpaRepository;
    private final CarToBuyEntityMapper carToBuyEntityMapper;

    @Override
    public Optional<CarToBuy> findCarToBuyByVin(String vin) {
        return carToBuyJpaRepository.findByVin(vin)
                .map(carToBuyEntityMapper::mapFromEntity);
    }
}
