package code.infrastructure.database.repository.jpa;

import code.infrastructure.database.entity.PartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartJpaRepository extends JpaRepository<PartEntity, Integer> {


}
