package code.business.dao;

import code.domain.Mechanic;

import java.util.Optional;

public interface MechanicDAO {

    Optional<Mechanic> findByPesel(String pesel);
}
