package code.infrastructure.database.repository.jpa;

import code.infrastructure.database.entity.CarToServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarToServiceJpaRepository extends JpaRepository<CarToServiceEntity, Integer> {


}
