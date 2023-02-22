package code;

import lombok.Builder;
import lombok.Getter;

import static code.UserManagmentService.mapOfUsers;

@Builder
@Getter
public class User implements Comparable<User> {
    private String name;
    private String surname;
    private String email;

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
      //  mapOfUsers.put(email, this);
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isPresent() {
        return mapOfUsers.containsValue(this);
    }

    public User get() {
        return this;
    }

    public boolean isEmpty() {
        for (String s : mapOfUsers.keySet()) {
            if (s.equals(this.getEmail())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(User o) {
        int result = this.email.compareTo(o.email);

        return result;
    }
}
