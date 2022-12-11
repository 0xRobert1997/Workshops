package Workshops.no1_genercis_and_collections.generics.genericInterface;

public class PackableBag implements Packable<Car>{

    @Override
    public void pack(Car element) {

    }

    @Override
    public Car empty() {
        return null;
    }
}
