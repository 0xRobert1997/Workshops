package Workshops.no3_localization_and_files.IO_in_out.printStreamWriter;

public class Car {

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
