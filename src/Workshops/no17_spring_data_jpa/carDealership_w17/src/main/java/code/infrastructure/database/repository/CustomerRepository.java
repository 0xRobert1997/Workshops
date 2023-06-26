package code.infrastructure.database.repository;

import code.business.dao.CustomerDAO;
import code.domain.Customer;
import code.infrastructure.database.entity.CarServiceRequestEntity;
import code.infrastructure.database.entity.CustomerEntity;
import code.infrastructure.database.entity.InvoiceEntity;
import code.infrastructure.database.repository.jpa.CarServiceRequestJpaRepository;
import code.infrastructure.database.repository.jpa.CustomerJpaRepository;
import code.infrastructure.database.repository.jpa.InvoiceJpaRepository;
import code.infrastructure.database.repository.mapper.CarServiceRequestEntityMapper;
import code.infrastructure.database.repository.mapper.CustomerEntityMapper;
import code.infrastructure.database.repository.mapper.InvoiceEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CustomerRepository implements CustomerDAO {

    private final CustomerJpaRepository customerJpaRepository;
    private final InvoiceJpaRepository invoiceJpaRepository;
    private final CarServiceRequestJpaRepository carServiceRequestJpaRepository;

    private final CustomerEntityMapper customerEntityMapper;
    private final InvoiceEntityMapper invoiceEntityMapper;
    private final CarServiceRequestEntityMapper carServiceRequestEntityMapper;
    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerJpaRepository.findByEmail(email)
                .map(customerEntityMapper::mapFromEntity);

    }

    @Override
    public void issueInvoice(Customer customer) {
        CustomerEntity customerToSave = customerEntityMapper.mapToEntity(customer);
        CustomerEntity customerSaved = customerJpaRepository.saveAndFlush(customerToSave);

        customer.getInvoices().stream()
                .filter(inv -> Objects.isNull(inv.getInvoiceId()))
                .map(invoiceEntityMapper::mapToEntity)
                .forEach(invoiceEntity -> {
                    invoiceEntity.setCustomer(customerSaved);
                    invoiceJpaRepository.saveAndFlush(invoiceEntity);
                });
    }

    @Override
    public void saveServiceRequest(Customer customer) {
        List<CarServiceRequestEntity> serviceRequests = customer.getCarServiceRequests().stream()
                .map(carServiceRequestEntityMapper::mapToEntity)
                .toList();
        serviceRequests
                .forEach(request -> request.setCustomer(customerEntityMapper.mapToEntity(customer)));
        carServiceRequestJpaRepository.saveAllAndFlush(serviceRequests);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity toSave = customerEntityMapper.mapToEntity(customer);
        CustomerEntity saved = customerJpaRepository.save(toSave);
        return customerEntityMapper.mapFromEntity(saved);
    }
}
