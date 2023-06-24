package code.business.dao;

import code.domain.Part;

import java.util.Optional;

public interface PartDAO {

    Optional<Part> findBySerialNumber(String serialNumber);
}
