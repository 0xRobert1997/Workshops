package code.infrastructure.database.repository;

import code.business.dao.CarServiceRequestDAO;
import code.domain.CarServiceRequest;
import code.infrastructure.database.repository.jpa.CarServiceRequestJpaRepository;
import code.infrastructure.database.repository.mapper.CarServiceRequestEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class CarServiceRequestRepository implements CarServiceRequestDAO {

    private final CarServiceRequestJpaRepository carServiceRequestJpaRepository;
    private final CarServiceRequestEntityMapper carServiceRequestEntityMapper;

    @Override
    public Set<CarServiceRequest> findActiveServiceRequestsByCarVin(String carVin) {

        return carServiceRequestJpaRepository.findActiveServiceRequestsByCarVin(carVin).stream()
                .map(carServiceRequestEntityMapper::mapFromEntity)
                .collect(Collectors.toSet());

    }
}
