package code.oneToMany;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

// dajemy @Getter i @Setter, przy @Data mogą wystąpić błędy(potem będzie jeszcze wyjaśnione)
@Getter
@Setter
// jeśli nadpiszemy quals po kluczu głównym, który jest serial to dopóki nie zapiszemy odbiektu do bazy danych to będzie on null'em
@EqualsAndHashCode(of = "email")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owner")
@NamedQueries(
        {
        @NamedQuery(
                name = "Owner.findAll",
                query = "FROM Owner"
        ),
        @NamedQuery(
                name = "Owner.findOwnerByEmail",
                query = "FROM Owner WHERE email = :email"
        )
        }
)
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
    @Fetch(value = FetchMode.SELECT) // przy ustawieniu JOIN hibernate użyje 1 joina zamiast 2 selectów
  //  @BatchSize(size = 3) //hibernate będzie dociągał encje w relacji w porcjach
    private Set<Pet> pets;

    public void removePet(final Pet pet) {
        pets.remove(pet);
    }

}
