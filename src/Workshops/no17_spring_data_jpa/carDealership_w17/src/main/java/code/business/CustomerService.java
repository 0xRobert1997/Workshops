package code.business;

import code.business.dao.CustomerDAO;
import code.domain.Address;
import code.domain.Customer;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class CustomerService {

    CustomerDAO customerDAO;

    public void issueInvoice(Customer customer) {
        customerDAO.issueInvoice(customer);
    }

    public Customer findCustomer(String email) {
        Optional<Customer> customerToFindByEmail = customerDAO.findByEmail(email);
        if (customerToFindByEmail.isEmpty()) {
            throw new RuntimeException("Could not find customer by email: [%s]".formatted(email));
        }
        return customerToFindByEmail.get();
    }

    public void saveServiceRequest(Customer customer) {
        customerDAO.saveServiceRequest(customer);
    }

    public Customer saveCustomer(Customer customer) {
        Customer entity = Customer.builder()
                .name(customer.getName())
                .surname(customer.getSurname())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .address(Address.builder()
                        .country(customer.getAddress().getCountry())
                        .city(customer.getAddress().getCity())
                        .postalCode(customer.getAddress().getPostalCode())
                        .address(customer.getAddress().getAddress())
                        .build())
                .build();
        return customerDAO.saveCustomer(entity);
    }
}
