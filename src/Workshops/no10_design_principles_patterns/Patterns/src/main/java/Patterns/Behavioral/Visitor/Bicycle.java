package Behavioral.Visitor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class Bicycle implements ShoppingCartElement{

    private BigDecimal price;

    private BigDecimal discount;

}
