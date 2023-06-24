package code.domain;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString(of = {"invoiceId", "invoiceNumber", "dateTime", "car", "salesman"})
@EqualsAndHashCode(of = {"invoiceId"})
@Builder
@With
public class Invoice {

    private Integer invoiceId;
    private String invoiceNumber;
    private OffsetDateTime dateTime;
    private CarToBuy car;
    private Customer customer;
    private Salesman salesman;

}
