package code.infrastructure.database.repository.jpa;

import code.infrastructure.database.entity.ServiceMechanicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceMechanicJpaRepository extends JpaRepository<ServiceMechanicEntity, Integer> {


}
