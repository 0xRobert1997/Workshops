package code;

import lombok.*;


@Builder
@Setter
@Getter
@EqualsAndHashCode
@With
@AllArgsConstructor
public class User implements Comparable<User> {
    private String name;
    private String surname;
    private String email;


    @Override
    public int compareTo(User o) {
        return this.email.compareTo(o.email);
    }


}
