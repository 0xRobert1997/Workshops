package Zajavka.zadania.cw15_javaAPI;

import java.util.Optional;

public class zad4 {

    public static void main(String[] args) {

        System.out.println(findUserByName("Rob"));


    }

    public static Optional<User> findUserByName(String name) {
        Optional<User> user1 = Optional.of(new User(666, name, "Bobowski"));
        return user1;
    }

    private void run() {
        Optional<User> user1 = findUserByName("Rafał");
        Optional<String> name = user1.map(u -> u.getName());
        Optional<String> filtered = name.filter(n -> n.startsWith("G"));
        filtered.orElseThrow( () -> new RuntimeException("User does not exist"));
    }
}
