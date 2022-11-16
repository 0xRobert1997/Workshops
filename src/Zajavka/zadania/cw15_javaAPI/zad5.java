package Zajavka.zadania.cw15_javaAPI;

import java.util.Optional;

public class zad5 {

    public static void main(String[] args) {


    }


    public static Optional<User> findUserByName(String name) {
        if (name.equals("Rafał")) {
            return Optional.of(new User(666, "Rafal", "Pepegacz"));
        }
        return Optional.empty();
    }

    public static void run() {
        Optional<User> user1 = findUserByName("Rafał");
        Optional<User> or = user1.or(() -> Optional.of(new User()));
        or.ifPresent(u -> System.out.println("User exists"));
    }

}
