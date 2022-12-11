package Workshops.no1_genercis_and_collections.generics.genericInterface;

public interface Packable<T> {

    void pack(T element);
    T empty();
}
