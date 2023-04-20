package Workshops.no11_next_java_versions.java9;

public interface Swim {

    // dodano prywatne metody do interface
    // (nie muszą być statyczne)
    // po co metoda prywatna w interface skoro nie można jej użyć w klasie która implementuje ten interface?
    // można jej używać np w metodzie defaultowej
    // trzeba pamiętąć że z metody statycznej nie pójdzie bo przecież z kontekstu statycznego nie można odwołać się bo kontekstu instancyjnego
    private static boolean areYouReady() {
        return true;
    }

    default void someMethod1() {
        areYouReady();
    }


}
