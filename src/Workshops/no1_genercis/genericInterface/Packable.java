package Workshops.no1_genercis.genericInterface;

public interface Packable<T> {

    void pack(T element);
    T empty();
}
