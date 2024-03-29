package pl.zajavka.business;

import pl.zajavka.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Customer create(Customer customer);

    void removeAll();

    Optional<Customer> find(String email);

    void remove(String email);

    List<Customer> findAll(String email);
    List<Customer> findAll();
}
