package Behavioral.Visitor;

import java.math.BigDecimal;

@FunctionalInterface
public interface ShoppingCartVisitor {

    BigDecimal visit(ShoppingCartElement element);


}
