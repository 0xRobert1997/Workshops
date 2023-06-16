package code.business.dao;

import code.infrastructure.database.entity.PartEntity;

import java.util.Optional;

public interface PartDAO {

    Optional<PartEntity> findBySerialNumber(String serialNumber);
}
