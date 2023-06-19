package pl.zajavka.zajavkastore.business;

import pl.zajavka.zajavkastore.infrastructure.database.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity getProduct(final Integer productId);

    void saveProduct(final ProductEntity productEntity);

    void deleteProduct(final Integer productId);
}
