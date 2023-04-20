package Workshops.no9_uml;

public interface Swim {

    String SWIMMING_SPEED = "50";

    static void someStaticMethod() {

    }

    default void cantSwim() {

    }

    String getName();
}
