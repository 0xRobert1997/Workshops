package code.infrastructure.database.entity;

import code.infrastructure.database.entity.CarToBuyEntity;
import code.infrastructure.database.entity.CustomerEntity;
import code.infrastructure.database.entity.SalesmanEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString(of = {"invoiceId", "invoiceNumber", "dateTime", "car", "salesman"})
@EqualsAndHashCode(of = {"invoiceId"})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoice")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Integer invoiceId;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "date_time")
    private OffsetDateTime dateTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_to_buy_id")
    private CarToBuyEntity car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salesman_id")
    private SalesmanEntity salesman;

}
