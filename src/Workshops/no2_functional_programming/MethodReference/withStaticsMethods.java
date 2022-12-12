package Workshops.no2_functional_programming.MethodReference;

public class Main {

    public static void main(String[] args) {

        MilkProducer producer = () -> "someMilk";
        MilkProducer producer2 = Main::someMilkReference;

        MilkConsumer consumer = a -> "someMilkConsumed: " + a;
        MilkConsumer consumer2 = Main::someMilkReference;

        System.out.println(producer.produce());
        System.out.println();
        System.out.println(producer2.produce());
        System.out.println();
        System.out.println(consumer.consume("milk"));
        System.out.println();
        System.out.println(consumer2.consume("milk"));
    }


    public static String someMilkReference() {
        System.out.println("Calling someMilkReference1");
        return "someMilkFromMethod";
    }

    public static String someMilkReference(String a) {
        System.out.println("Calling someMilkReference1");
        return "someMilkFromMethod: " + a;
    }

    @FunctionalInterface
    interface MilkProducer {
        String produce();
    }

    @FunctionalInterface
    interface MilkConsumer {
        String consume(String toConsume);
    }
}
