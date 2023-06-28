package code.infrastructure.database.repository;

import code.business.dao.PartDAO;
import code.domain.Part;
import code.infrastructure.database.repository.jpa.PartJpaRepository;
import code.infrastructure.database.repository.mapper.PartEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class PartRepository implements PartDAO {

    private final PartJpaRepository partJpaRepository;
    private final PartEntityMapper partEntityMapper;

    @Override
    public Optional<Part> findBySerialNumber(String serialNumber) {
        return partJpaRepository.findBySerialNumber(serialNumber)
                .map(partEntityMapper::mapFromEntity);

    }
}
