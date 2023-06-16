package code.business.dao;

import code.infrastructure.database.entity.MechanicEntity;

import java.util.Optional;

public interface MechanicDAO {

    Optional<MechanicEntity> findByPesel(String pesel);
}
