package Structural.Decorator.AttributeDecorator;

import org.jsoup.nodes.Attribute;

public class AttributeAfterDecorator extends AttributeDecorator{

    public AttributeAfterDecorator(Attribute attribute) {
        super(attribute);
    }

    @Override
    public String getKey() {
        System.out.println("Decorating after getKey()");
        return super.getKey();
    }
}
