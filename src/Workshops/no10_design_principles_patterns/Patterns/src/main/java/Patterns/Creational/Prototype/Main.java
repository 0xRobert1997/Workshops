package Patterns.Creational.Prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

//        PrototypeCar prototypeCar = new PrototypeCar();
//        SteeringWheel steeringWheel = new SteeringWheel();
//        steeringWheel.setDiameter(10.5);
//        prototypeCar.setSteeringWheel(steeringWheel);
//
//        PrototypeCar shallowCopy = prototypeCar.shallowCopy();
//        PrototypeCar deepCopy = prototypeCar.deepCopy();
//
//        System.out.println("1 shallow copied == " + (prototypeCar == shallowCopy));
//        System.out.println("2 shallow copied equals " + (prototypeCar.equals(shallowCopy)));
//
//        System.out.println("3 shallow copied == " + (prototypeCar.getSteeringWheel() == shallowCopy.getSteeringWheel()));
//        System.out.println("4 shallow copied equals " + (prototypeCar.getSteeringWheel().equals(shallowCopy.getSteeringWheel())));
//
//        System.out.println("5 deep copied == " + (prototypeCar.getSteeringWheel() == deepCopy.getSteeringWheel()));
//        System.out.println("6 deep copied equals " + (prototypeCar.getSteeringWheel().equals(deepCopy.getSteeringWheel())));


        PrototypeCar original = new PrototypeCar();
        PrototypeCar cloned = original.clone();


        System.out.println(original == cloned);
        System.out.println(original.getSteeringWheel() == cloned.getSteeringWheel());
        System.out.println(original.getBrand() == cloned.getBrand());
        System.out.println(original.getModel() == cloned.getModel());
        System.out.println(original.getDoors()== cloned.getDoors());


        System.out.println(original);
        System.out.println(cloned);
        cloned.getDoors().add("back door");
        System.out.println(original);
        System.out.println(cloned);
    }
}
