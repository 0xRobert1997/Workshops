package Exercises.zad7_Composite;

public class Application {
    public static void main(String[] args) {
        Composite composite = new Composite("Composite");
        composite.add(new Leaf("Leaf1"));
        composite.add(new Leaf("Leaf2"));
        Composite subComposite = new Composite("subComposite");
        subComposite.add(new Leaf("Leaf3"));
        composite.add(subComposite);
        composite.operation();
    }
    /*
    Operation performed on a composite: Composite
    Operation performed on a leaf: Leaf1
    Operation performed on a leaf: Leaf2
    Operation performed on a composite: subComposite
    Operation performed on a leaf: Leaf3
     */
}
