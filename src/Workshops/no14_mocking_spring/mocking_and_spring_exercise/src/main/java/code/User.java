package code;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@With
@Builder
public class User implements Comparable<User> {
    String name;
    String surname;
    String email;

    @Override
    public int compareTo(User o) {
        return this.email.compareTo(o.email);
    }
}
