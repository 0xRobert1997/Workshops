package code.oneToMany;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

// dajemy @Getter i @Setter, przy @Data mogą wystąpić błędy(potem będzie jeszcze wyjaśnione)
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="owner_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Pet> pets;

}
