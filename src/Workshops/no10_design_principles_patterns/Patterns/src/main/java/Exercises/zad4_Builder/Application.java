package Exercises.zad4_Builder;

public class Application {

    public static void main(String[] args) {

        User user = User.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .email("test.email@gmail.com")
                .build();
        System.out.println(user);
    }
}
