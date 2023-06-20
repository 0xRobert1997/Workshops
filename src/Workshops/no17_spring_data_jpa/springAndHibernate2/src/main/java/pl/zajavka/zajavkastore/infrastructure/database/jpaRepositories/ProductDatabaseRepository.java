package pl.zajavka.zajavkastore.infrastructure.database.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajavka.zajavkastore.infrastructure.database.entity.ProductEntity;

@Repository
public interface ProductDatabaseRepository extends JpaRepository<ProductEntity, Integer> {


}
