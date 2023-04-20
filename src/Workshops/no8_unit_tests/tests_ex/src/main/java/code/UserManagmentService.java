package code;

import java.util.*;

public class UserManagmentService {

    private final Map<String, User> mapOfUsers = new HashMap<>();

    void create(User user) {
        if (mapOfUsers.containsKey(user.getEmail())) {
            throw new RuntimeException("User with email: [" + user.getEmail() + "] is already created");
        }
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

    public void update(String email, User withNewEmail) {

        if (mapOfUsers.containsKey(email)) {
            User userToUpdate = mapOfUsers.get(email);
            User userToUpdate2 = new User(userToUpdate.getName(), userToUpdate.getSurname(), userToUpdate.getEmail());
            mapOfUsers.remove(email);
            userToUpdate2.setEmail(withNewEmail.getEmail());
            mapOfUsers.put(userToUpdate2.getEmail(), userToUpdate2);

        } else {
            throw new RuntimeException("User with email: [" + email + "] doesn't exist");
        }
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
        } else {
            throw new RuntimeException("User with email: [" + email + "] doesn't exist");
        }
    }
}
