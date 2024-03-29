package code.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@ToString(of = {"partId", "serialNumber", "description", "price"})
@EqualsAndHashCode(of = {"partId"})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "part")
public class PartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    private Integer partId;

    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "part")
    private Set<ServicePartEntity> serviceParts;


}
