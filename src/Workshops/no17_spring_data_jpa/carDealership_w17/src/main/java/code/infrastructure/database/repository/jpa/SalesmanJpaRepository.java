package code.infrastructure.database.repository.jpa;

import code.infrastructure.database.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesmanJpaRepository extends JpaRepository<AddressEntity, Integer> {


}
