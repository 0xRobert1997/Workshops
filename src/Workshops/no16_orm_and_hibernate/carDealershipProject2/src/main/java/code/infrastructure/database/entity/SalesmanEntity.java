package code.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(of = {"salesmanId"})
@EqualsAndHashCode(of = {"salesmanId", "name", "surname", "pesel"})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salesman")
public class SalesmanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salesman_id")
    private Integer salesmanId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "pesel", unique = true)
    private String pesel;


    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "salesman")
    private Set<InvoiceEntity> invoices;
}
