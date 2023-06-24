package code.business.dao;

import code.domain.Service;

import java.util.Optional;

public interface ServiceDAO {

    Optional<Service> findByServiceCode(String serviceCode);
}
