package code.domain;

import code.infrastructure.database.entity.CustomerEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.With;

@With
@Value
@Builder
@EqualsAndHashCode(of = "addressId")
public class Address {

    Integer addressId;
    String country;
    String city;
    String postalCode;
    String address;
    Customer customer;
}
