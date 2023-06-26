package code.infrastructure.database.repository.jpa;

import code.infrastructure.database.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceJpaRepository extends JpaRepository<ServiceEntity, Integer> {


    Optional<ServiceEntity> findByServiceCode(String serviceCode);
}
