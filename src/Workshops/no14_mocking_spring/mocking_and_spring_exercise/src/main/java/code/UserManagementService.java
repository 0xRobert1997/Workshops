package code;

import java.util.List;
import java.util.Optional;

public class UserManagementService {

    private UserManagementRepository userManagementRepository;

    public void create(User user) {
        if (userManagementRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException(String.format("User with email: [%s] is already created", user.getEmail()));
        }
        userManagementRepository.create(user);
    }

    public Optional<User> findByEmail(String email) {
        return userManagementRepository.findByEmail(email);
    }

    public List<User> findAll() {
        return userManagementRepository.findAll();
    }

    public List<User> findByName(String name) {
        return userManagementRepository.findByName(name);
    }

    public void update(String email, User withEmail) {
        if (userManagementRepository.findByEmail(email).isEmpty()) {
            throw new RuntimeException(String.format("User with email: [%s] doesn't exist", email));
        }
        userManagementRepository.update(email, withEmail);

    }

    public void delete(String email) {
        if (userManagementRepository.findByEmail(email).isEmpty()) {
            throw new RuntimeException(String.format("User with email: [%s] doesn't exist", email));
        }
        userManagementRepository.delete(email);
    }
}
