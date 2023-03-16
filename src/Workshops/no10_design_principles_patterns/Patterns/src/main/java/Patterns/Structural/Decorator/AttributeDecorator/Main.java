package Structural.Decorator.AttributeDecorator;

import org.jsoup.nodes.Attribute;

public class Main {

    public static void main(String[] args) {

        System.out.println("Example1");
        Attribute attribute1 = new AttributeBeforeDecorator(new Attribute("key1", "value1"));
        System.out.println(attribute1.getKey());
        System.out.println();

        System.out.println("Example2");
        Attribute attribute2 = new AttributeAfterDecorator(new AttributeBeforeDecorator(new Attribute("key2", "value2")));
        System.out.println(attribute2.getKey());
    }
}
