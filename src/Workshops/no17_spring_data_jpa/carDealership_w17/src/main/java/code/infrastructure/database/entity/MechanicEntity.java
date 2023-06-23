package code.infrastructure.database.entity;

import code.infrastructure.database.entity.ServiceMechanicEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(of = {"mechanicId", "name", "surname", "pesel"})
@EqualsAndHashCode(of = {"mechanicId"})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mechanic")
public class MechanicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mechanic_id")
    private Integer mechanicId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "pesel", unique = true)
    private String pesel;


    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "mechanic")
    private Set<ServiceMechanicEntity> serviceMechanics;
}
