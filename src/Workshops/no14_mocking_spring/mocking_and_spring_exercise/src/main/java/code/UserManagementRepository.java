package code;

import java.util.List;
import java.util.Optional;

public interface UserManagementRepository {

    void create(User user);
    Optional<User> findByEmail(String email);
    List<User> findByName(String name);

    List<User> findAll();
    void update(String email, User user);
    void delete(String email);
}
