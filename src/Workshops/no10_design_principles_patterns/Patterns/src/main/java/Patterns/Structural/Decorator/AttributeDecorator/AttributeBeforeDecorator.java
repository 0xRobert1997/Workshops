package Structural.Decorator.AttributeDecorator;

import org.jsoup.nodes.Attribute;

public class AttributeBeforeDecorator extends AttributeDecorator{

    public AttributeBeforeDecorator(Attribute attribute) {
        super(attribute);
    }

    @Override
    public String getKey() {
        System.out.println("Decorating before getKey()");
        return super.getKey();
    }
}
