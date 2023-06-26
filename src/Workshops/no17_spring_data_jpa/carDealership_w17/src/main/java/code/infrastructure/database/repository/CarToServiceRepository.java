package code.infrastructure.database.repository;

import code.business.dao.CarToServiceDAO;
import code.domain.CarHistory;
import code.domain.CarToService;
import code.infrastructure.database.entity.CarToServiceEntity;
import code.infrastructure.database.repository.jpa.CarToServiceJpaRepository;
import code.infrastructure.database.repository.mapper.CarToServiceEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@AllArgsConstructor
public class CarToServiceRepository implements CarToServiceDAO {

    private final CarToServiceJpaRepository carToServiceJpaRepository;
    private final CarToServiceEntityMapper carToServiceEntityMapper;
    @Override
    public Optional<CarToService> findCarToServiceByVin(String vin) {
        return carToServiceJpaRepository.findOptionalByVin(vin)
                .map(carToServiceEntityMapper::mapFromEntity);
    }

    @Override
    public CarToService saveCarToService(CarToService entity) {
        CarToServiceEntity toSave = carToServiceEntityMapper.mapToEntity(entity);
        CarToServiceEntity saved = carToServiceJpaRepository.save(toSave);
        return carToServiceEntityMapper.mapFromEntity(saved);
    }

    @Override
    public CarHistory findCarHistoryByVin(String vin) {
        CarToServiceEntity entity = carToServiceJpaRepository.findByVin(vin);
        return carToServiceEntityMapper.mapFromEntity(vin, entity);
    }
}
