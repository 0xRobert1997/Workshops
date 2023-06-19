package pl.zajavka.zajavkastore.infrastructure.database.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajavka.zajavkastore.infrastructure.database.entity.OpinionEntity;

@Repository
public interface OpinionDatabaseRepository extends JpaRepository<OpinionEntity, Integer> {


}
