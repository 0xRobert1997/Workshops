package code.infrastructure.database.repository;

import code.business.dao.ServiceDAO;
import code.domain.Service;
import code.infrastructure.database.repository.jpa.ServiceJpaRepository;
import code.infrastructure.database.repository.mapper.ServiceEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ServiceRepository implements ServiceDAO {

    private final ServiceJpaRepository serviceJpaRepository;
    private final ServiceEntityMapper serviceEntityMapper;
    @Override
    public Optional<Service> findByServiceCode(String serialNumber) {
        return serviceJpaRepository.findBySerialNumber(serialNumber)
                .map(serviceEntityMapper::mapFromEntity);

    }
}
