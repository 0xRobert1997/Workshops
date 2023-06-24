package code.infrastructure.database.repository.jpa;

import code.infrastructure.database.entity.ServicePartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicePartJpaRepository extends JpaRepository<ServicePartEntity, Integer> {


}
