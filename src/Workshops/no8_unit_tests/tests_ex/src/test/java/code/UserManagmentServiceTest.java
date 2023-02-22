package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserManagmentServiceTest {

    private UserManagmentService userManagmentService;

    @BeforeEach
    void init() {
        this.userManagmentService = new UserManagmentService();
    }

    @Test
    void shouldCreateUserCorretly() {
        //given
        var user = someUser();
        //when
        userManagmentService.create(user);
        var result = userManagmentService.findByEmail(user.getEmail());
        //then
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(user, result.get());
    }

    @Test
    void shouldCreateMultipleUsersCorrectly() {
    //given
    var user1 = someUser().withEmail("email1@gmail.com");
    var user2 = someUser().withEmail("email2@gmail.com");
    var user3 = someUser().withEmail("email3@gmail.com");

    //when
        userManagmentService.create(user1);
        userManagmentService.create(user2);
        userManagmentService.create(user3);

        var result1 = userManagmentService.findByEmail(user1.getEmail());
        var result2 = userManagmentService.findByEmail(user2.getEmail());
        var result3 = userManagmentService.findByEmail(user3.getEmail());
        var all = userManagmentService.findAll();

        //then
        Assertions.assertEquals(3, all.size());
        Assertions.assertTrue(result1.isPresent());
        Assertions.assertEquals(user1, result1.get());
        Assertions.assertTrue(result2.isPresent());
        Assertions.assertEquals(user2, result2.get());
        Assertions.assertTrue(result2.isPresent());
        Assertions.assertEquals(user3, result3.get());
    }

    @Test
    void shouldFailWhenDuplicatedUserIsCreated() {
        //given
        var user1 = someUser();
        var user2 = someUser();

        //when, then
        userManagmentService.create(user1);
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> userManagmentService.create(user2));
        Assertions.assertEquals(String.format("User with email: [%s] is already created", user1.getEmail()), exception.getMessage());
    }

    @Test
    void shouldFindUserWithName() {
    //given
    var user1 = someUser().withEmail("email1@gmail.com");
    var user2 = someUser().withEmail("email2@gmail.com");
    var user3 = someUser().withName("newName").withEmail("email3@gmail.com");

    //when
        userManagmentService.create(user1);
        userManagmentService.create(user2);
        userManagmentService.create(user3);

        var result1 = userManagmentService.findByName(user1.getName());
        var result2 = userManagmentService.findByName(user2.getName());
        var result3 = userManagmentService.findByName(user3.getName());
        var all = userManagmentService.findAll();

        // then
        Assertions.assertEquals(3, all.size());
        Assertions.assertEquals(
                Stream.of(user1, user2).sorted().collect(Collectors.toList()),
                result1.stream().sorted().collect(Collectors.toList())
        );
        Assertions.assertEquals(
                Stream.of(user1, user2).sorted().collect(Collectors.toList()),
        result2.stream().sorted().collect(Collectors.toList())
        );

                Assertions.assertEquals(List.of(user3), result3);

    }
    @Test
    void shouldModifyUserDataCorrectly() {
        //given
        var user1 = someUser().withEmail("email1@gmail.com");
        var user2 = someUser().withEmail("email2@gmail.com");
        var user3 = someUser().withEmail("email3@gmail.com");
        String newEmail = "newEmail@gmail.com";

        //when
        UserManagmentService.create(user1);
        UserManagmentService.create(user2);
        UserManagmentService.create(user3);

        var all = userManagmentService.findAll();
        Assertions.assertEquals(3, all.size());

        var result1 = userManagmentService.findByEmail(user1.getEmail());
        userManagmentService.update(user1.getEmail(), user1.withEmail(newEmail));
        var result2 = userManagmentService.findByEmail(user1.getEmail());
        var result3 = userManagmentService.findByEmail(newEmail);
        var allAgain = userManagmentService.findAll();

        //then
        Assertions.assertEquals(3, allAgain.size());
        Assertions.assertTrue(result1.isPresent());
        Assertions.assertEquals(user1, result1.get());
        Assertions.assertTrue(result2.isEmpty());
        Assertions.assertTrue(result3.isPresent());
        Assertions.assertEquals(user1.withEmail(newEmail), result3.get());
    }

    @Test
    void shouldThrowWhenModifyingNonExistingUser() {
        //given
        var user1 = someUser();
        String newEmail = "email1@gmail.com";

        //when, then
        Throwable exception = Assertions.assertThrows(RuntimeException.class,
                () -> userManagmentService.update(user1.getEmail(), user1.withEmail(newEmail)));
        Assertions.assertEquals(String.format("User with email: [%s] doesn't exist", user1.getEmail()), exception.getMessage());
    }

    @Test
    void shouldDeleteUserCorrectly() {
        // given
        var user1 = someUser().withEmail("email1@gmail.com");
        var user2 = someUser().withEmail("email2@gmail.com");
        var user3 = someUser().withEmail("email3@gmail.com");

        //when
        userManagmentService.create(user1);
        UserManagmentService.create(user2);
        UserManagmentService.create(user3);

        var all = userManagmentService.findAll();
        Assertions.assertEquals(3, all.size());

        userManagmentService.delete(user1.getEmail());

        var result1 = userManagmentService.findByEmail(user1.getEmail());
        var result2 = userManagmentService.findByEmail(user2.getEmail());
        var result3 = userManagmentService.findByEmail(user3.getEmail());
        var allAgain = userManagmentService.findAll();

        // then
        Assertions.assertEquals(2, allAgain.size());
        Assertions.assertTrue(result1.isEmpty());
        Assertions.assertTrue(result2.isPresent());
        Assertions.assertEquals(user2, result2.get());
        Assertions.assertTrue(result3.isPresent());
        Assertions.assertEquals(user3, result3.get());
    }

    @Test
    void shouldThrownWhenDeletingNonExistingUser() {
        // given
        var user1 = someUser().withEmail("email1@gmail.com");
        //when, then
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> userManagmentService.delete(user1.getEmail()));
        Assertions.assertEquals(String.format("User with email: [%s] doesn't exist", user1.getEmail()), exception.getMessage());
    }

    private static User someUser() {
        return User.builder()
                .name("name")
                .surname("surname")
                .email("email@gmail.com")
                .build();
    }




}
