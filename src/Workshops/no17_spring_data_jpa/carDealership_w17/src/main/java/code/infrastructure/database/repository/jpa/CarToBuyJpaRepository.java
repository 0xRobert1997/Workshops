package code.infrastructure.database.repository.jpa;

import code.infrastructure.database.entity.CarToBuyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarToBuyJpaRepository extends JpaRepository<CarToBuyEntity, Integer> {


    Optional<CarToBuyEntity> findByVin(String vin);
}
