package code.domain;

import code.infrastructure.database.entity.AddressEntity;
import code.infrastructure.database.entity.CarServiceRequestEntity;
import code.infrastructure.database.entity.InvoiceEntity;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString(of = {"customerId", "name", "surname", "email"})
@EqualsAndHashCode(of = {"customerId"})
@Builder
@With
public class Customer {

    Integer customerId;
    String name;
    String surname;
    String phone;
    String email;
    Address address;
    Set<Invoice> invoices;
    Set<CarServiceRequest> carServiceRequests;

    public Set<Invoice> getInvoices() {
        return Objects.isNull(invoices) ? new HashSet<>() : invoices;
    }

    public Set<CarServiceRequest> getCarServiceRequests() {
        return Objects.isNull(carServiceRequests) ? new HashSet<>() : carServiceRequests;
    }
}
