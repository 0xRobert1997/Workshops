package Workshops.no3_localization_and_files.IO_in_out.Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File destination = new File("object.whatever");

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford mustang", 1969L, List.of(new Door("left"), new Door("right"))));
        cars.add(new Car("BMW 3", 1969L, List.of(new Door("left"), new Door("right"))));
        cars.add(new Car("Mercedes G-class", 1969L, List.of(new Door("left"), new Door("right"))));

        List<Car> carDeserialized = deserialize(destination);
        System.out.println(carDeserialized);


        List<Persian> dogs = new ArrayList<>();
        System.out.println("SERIALIZING");
        dogs.add(new Persian("Burek", "Burecki"));
        dogs.add(new Persian("Fafik", "Fafikowy"));
        dogs.add(new Persian("Aport", "Aporciński"));

        serialize(dogs, destination);
        System.out.println();
        System.out.println();


        System.out.println("DESERIALIZING");
        List<Car> dogsDeserialized = deserialize(destination);
        System.out.println(dogsDeserialized);

    }

    private static List<Car> deserialize(File destination) throws IOException, ClassNotFoundException {
        List<Car> result = new ArrayList<>();

        try (ObjectInputStream inputStream =
                        new ObjectInputStream(
                                new BufferedInputStream(
                                        new FileInputStream(destination)))
        ) {
            while (true) {
                Object object = inputStream.readObject();
                if (!(object instanceof Car)) {
                    System.out.println("Object is not concrete");
                    continue;
                }
                Car concreteObject = (Car) object;
                System.out.println("Successfully read object: " + concreteObject);
                result.add( concreteObject);
            }
        } catch (EOFException e) {
            System.out.println("end of file");
        }
        return result;
    }

    private static void serialize(List<?> cars, File destination) throws IOException {
        try (ObjectOutputStream outputStream =
                        new ObjectOutputStream(
                                new BufferedOutputStream(
                                        new FileOutputStream(destination)))
        ) {
            for (Object object : cars) {
                outputStream.writeObject(object);
            }
        }
    }
}
