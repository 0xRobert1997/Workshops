package code;

import lombok.Value;

import java.util.*;

@Value
public class UserManagementInMemoryRepository implements UserManagementRepository {

    HashMap<String, User> usersMap = new HashMap<>();

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(usersMap.get(email));
    }

    @Override
    public List<User> findByName(String name) {
        ArrayList<User> myList = new ArrayList<>();
        for (User user : usersMap.values()) {
            if (user.getName().equals(name)){
                myList.add(user);
            }
        }
        return myList;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(usersMap.values());
    }

    @Override
    public void update(String email, User user) {
        if (!email.equals(user.getEmail())) {
            usersMap.remove(email);
        }
        usersMap.put(user.getEmail(), user);
    }

    @Override
    public void delete(String email) {
        usersMap.remove(email);
    }

    @Override
    public void create(User user) {
        usersMap.put(user.getEmail(), user);
    }
}
