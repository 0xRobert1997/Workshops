package code.domain;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(of = {"salesmanId"})
@EqualsAndHashCode(of = {"salesmanId", "name", "surname", "pesel"})
@Builder
@With
public class Salesman {

    private Integer salesmanId;
    private String name;
    private String surname;
    private String pesel;
    private Set<Invoice> invoices;
}
