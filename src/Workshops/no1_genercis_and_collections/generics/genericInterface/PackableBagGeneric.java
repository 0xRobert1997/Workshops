package Workshops.no1_genercis_and_collections.generics.genericInterface;

public class PackableBagGeneric<T> implements Packable<T> {
    @Override
    public void pack(T element) {

    }

    @Override
    public T empty() {
        return null;
    }
}
