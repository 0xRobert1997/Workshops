package BDD;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserRegistryService {

    private final UserRepository userRepository;

    public void register(User user) {
        if (!user.isValid() || userRepository.contains(user.getPhone())) {
            throw new RuntimeException("Invalid user data");
        }
        userRepository.put(user);
    }

    public Optional<User> find(String phone) {
        if (phone.isEmpty()) {
            throw new RuntimeException("Invalid phone number");
        }
        if (userRepository.contains(phone)) {
            return Optional.ofNullable(userRepository.find(phone));
        }
        return Optional.empty();
    }
}
