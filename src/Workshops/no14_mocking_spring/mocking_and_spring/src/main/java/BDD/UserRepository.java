package BDD;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private final Map<String, User> USER_MAP = new HashMap<>();

    public void put(final User user) {
        if (user.getPhone().length() > 7) {
            throw  new RuntimeException("Phone number is too long");
        }
        if (USER_MAP.containsKey(user.getPhone())) {
            throw new RuntimeException(
                    String.format("Phone: %s already exists in registry", user.getPhone()));
        }
        USER_MAP.put(user.getPhone(), user);
    }
    public boolean contains(final String phone) {
        return USER_MAP.containsKey(phone);
    }

    public User find(final String phone) {
        return USER_MAP.get(phone);
    }
    private boolean testin() {
        return true;
    }
}
