package code.business;

import code.business.dao.CustomerDAO;
import code.domain.CarServiceRequest;
import code.infrastructure.database.entity.AddressEntity;
import code.infrastructure.database.entity.CustomerEntity;
import lombok.AllArgsConstructor;

import java.util.Optional;
@AllArgsConstructor
public class CustomerService {

    CustomerDAO customerDAO;
    public void issueInvoice(CustomerEntity customer) {
        customerDAO.issueInvoice(customer);
    }

    public CustomerEntity findCustomer(String email) {
        Optional<CustomerEntity> customerToFindByEmail = customerDAO.findByEmail(email);
        if (customerToFindByEmail.isEmpty()) {
            throw new RuntimeException("Could not find customer by email: [%s]".formatted(email));
        }
        return customerToFindByEmail.get();
    }

    public void saveServiceRequest(CustomerEntity customer) {
        customerDAO.saveServiceRequest(customer);
    }

    public CustomerEntity saveCustomer(CarServiceRequest.Customer customer) {
        CustomerEntity entity = CustomerEntity.builder()
                .name(customer.getName())
                .surname(customer.getSurname())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .address(AddressEntity.builder()
                        .country(customer.getAddress().getCountry())
                        .city(customer.getAddress().getCity())
                        .postalCode(customer.getAddress().getPostalCode())
                        .address(customer.getAddress().getAddress())
                        .build())
                .build();
        return customerDAO.saveCustomer(entity);
    }
}
