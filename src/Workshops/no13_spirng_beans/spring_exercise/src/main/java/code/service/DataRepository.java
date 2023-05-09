package code.service;

import code.Domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class DataRepository {

    public List<User> readUsers() {

        try {
            return Files.readAllLines(ResourceUtils.getFile("classpath:users.csv").toPath())
                    .stream()
                    .skip(1)
                    .map(this::mapUser)
                    .filter(user -> user.isPresent())
                    .map(opt -> opt.get())
                    .toList();

        } catch (IOException e) {
            log.error("Error while reading");
            return List.of();
        }
    }

    private Optional<User> mapUser(String line) {
        if (!line.contains("@")) {
            return Optional.empty();
        }
        List<String> lineAsList = Arrays.asList(line.split(";"));
        return Optional.of(User.builder()
                .email(lineAsList.get(0))
                .name(lineAsList.get(1))
                .publicName(lineAsList.get(2))
                .birthDate(LocalDate.parse(lineAsList.get(3)))
                .build());
    }

    public void save(final List<String> processed) {
        try {
            Files.write(Paths.get("./result.txt"), processed);
        } catch (IOException e) {
            log.error("Error while saving data", e.getMessage());
        }
    }
}
