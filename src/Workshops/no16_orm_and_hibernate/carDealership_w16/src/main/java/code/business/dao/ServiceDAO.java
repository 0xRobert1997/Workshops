package code.business.dao;

import code.infrastructure.database.entity.ServiceEntity;

import java.util.Optional;

public interface ServiceDAO {

    Optional<ServiceEntity> findByServiceCode(String serviceCode);
}
