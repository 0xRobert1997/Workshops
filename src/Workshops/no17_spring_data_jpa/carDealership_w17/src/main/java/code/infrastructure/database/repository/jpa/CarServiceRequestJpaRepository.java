package code.infrastructure.database.repository.jpa;

import code.domain.CarServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarServiceRequestJpaRepository extends JpaRepository<CarServiceRequest, Integer> {


}
