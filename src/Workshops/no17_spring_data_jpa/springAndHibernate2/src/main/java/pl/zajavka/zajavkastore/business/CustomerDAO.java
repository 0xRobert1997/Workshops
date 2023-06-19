package pl.zajavka.zajavkastore.business;

import pl.zajavka.zajavkastore.infrastructure.database.entity.CustomerEntity;

public interface CustomerDAO {

    CustomerEntity getCustomer(final Integer customerId);

    void saveCustomer(final CustomerEntity customerEntity);

    void deleteCustomer(final Integer customerId);
}
