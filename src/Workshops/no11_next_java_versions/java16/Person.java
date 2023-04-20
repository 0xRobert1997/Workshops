package Workshops.no11_next_java_versions.java16;

public record Person<T>(
        String name,
        String surname,
        Long age,
        T someGeneric
        // rekordy moga implementować interface ale nie mogą dziedziczyc z innych klas
) implements SomeInterface {

    public static final String SOMETHING = "SOMETHING";
    public static final Integer INTEGER;

    static {
        INTEGER = 420;
    }



    boolean isMature() {
        return false;
    }


}
