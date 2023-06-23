package code.infrastructure.database.entity;

import code.infrastructure.database.entity.CustomerEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(of = {"addressId", "country", "city", "postalCode", "address"})
@EqualsAndHashCode(of ="addressId")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "address")
    private String address;

    @OneToOne(fetch =  FetchType.LAZY, mappedBy = "address")
    private CustomerEntity customer;
}
