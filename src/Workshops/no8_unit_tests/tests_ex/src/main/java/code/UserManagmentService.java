package code;

import java.util.*;

public class UserManagmentService {

    public static Map<String, User> mapOfUsers = new HashMap<>();

    static void create(User user) {

        mapOfUsers.put(user.getEmail(), user);
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(mapOfUsers.get(email));
    }

    public Map<String, User> findAll() {
        return mapOfUsers;
    }

    public ArrayList<User> findByName(String name) {
        ArrayList<User> listOfUsers = new ArrayList<>();
        for (User user : mapOfUsers.values()) {
            if (user.getName().equals(name)) {
                listOfUsers.add(user);
            }
        }
        return listOfUsers;
    }

    public void update(String email, User withEmail) {

    }

    public void delete(String email) {
        boolean temp = false;
        for (String s : mapOfUsers.keySet()) {
            if (email.equals(s)) {
                temp = true;
            }
        }
        if (temp) {
            mapOfUsers.remove(email);
        }

    }
}
