package code.business.dao;

import code.domain.Salesman;

import java.util.Optional;

public interface SalesmanDAO {
    Optional<Salesman> findByPesel(String pesel);
}
