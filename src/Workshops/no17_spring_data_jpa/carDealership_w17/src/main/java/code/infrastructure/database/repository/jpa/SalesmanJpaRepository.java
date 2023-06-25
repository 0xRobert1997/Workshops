package code.infrastructure.database.repository.jpa;

import code.infrastructure.database.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesmanJpaRepository extends JpaRepository<AddressEntity, Integer> {


    Optional<AddressEntity> findByPesel(String pesel);
}
