package code.business.dao;

import code.infrastructure.database.entity.SalesmanEntity;

import java.util.Optional;

public interface SalesmanDAO {
    Optional<SalesmanEntity> findSalesmanByPesel(String pesel);
}
