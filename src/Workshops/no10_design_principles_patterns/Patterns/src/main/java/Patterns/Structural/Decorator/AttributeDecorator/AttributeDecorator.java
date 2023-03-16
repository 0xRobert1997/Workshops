package Structural.Decorator.AttributeDecorator;

import org.jsoup.nodes.Attribute;

public class AttributeDecorator extends Attribute {

    private final Attribute attribute;

    public AttributeDecorator(Attribute attribute) {
        super(attribute.getKey(), attribute.getValue());
        this.attribute = attribute;
    }

    @Override
    public String getKey() {
        return super.getKey();
    }
}
