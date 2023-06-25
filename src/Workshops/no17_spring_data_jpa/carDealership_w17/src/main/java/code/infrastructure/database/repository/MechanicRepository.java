package code.infrastructure.database.repository;

import code.business.dao.MechanicDAO;
import code.domain.Mechanic;
import code.infrastructure.database.repository.jpa.MechanicJpaRepository;
import code.infrastructure.database.repository.mapper.MechanicEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class MechanicRepository implements MechanicDAO {
    private final MechanicJpaRepository mechanicJpaRepository;
    private final MechanicEntityMapper mechanicEntityMapper;
    @Override
    public Optional<Mechanic> findByPesel(String pesel) {
        return mechanicJpaRepository.findByPesel(pesel)
                .map(mechanicEntityMapper::mapFromEntity);
    }

}
