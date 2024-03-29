package pl.zajavka.zajavkastore.infrastructure.database.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zajavka.zajavkastore.infrastructure.database.entity.ProducerEntity;
import pl.zajavka.zajavkastore.infrastructure.database.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProducerDatabaseRepository extends JpaRepository<ProducerEntity, Integer> {

    List<ProductEntity> findByProductPriceGreaterThan(BigDecimal price);

    List<ProductEntity> findByProductPriceLessThan(BigDecimal price);

    List<ProductEntity> findByProductPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    List<ProductEntity> findByProductNameContaining(String name);

    List<ProductEntity> findByProductLike(String name);
}
