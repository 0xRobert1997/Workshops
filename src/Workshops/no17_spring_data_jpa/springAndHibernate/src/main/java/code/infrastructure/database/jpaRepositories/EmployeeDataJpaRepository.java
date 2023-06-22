package code.infrastructure.database.jpaRepositories;

import code.infrastructure.database.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDataJpaRepository extends JpaRepository<EmployeeEntity, Integer> {

    Optional<EmployeeEntity> findByNameAndSurname(String name, String surname);

    void deleteByNameAndSurname(String name, String surname);


}
