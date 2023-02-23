package code;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter
@Getter
@EqualsAndHashCode
public class User implements Comparable<User> {
    private String name;
    private String surname;
    private String email;

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    @Override
    public int compareTo(User o) {
        return this.email.compareTo(o.email);
    }

    public User withName(String name) {
        return this.name == name ? this : new User(name, this.surname, this.email);
    }

    public User withSurname(String surname) {
        return this.surname == surname ? this : new User(this.name, surname, this.email);
    }

    public User withEmail(String email) {
        return this.email == email ? this : new User(this.name, this.surname, email);
    }
}
