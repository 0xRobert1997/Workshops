package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserManagmentServiceTest {
    @InjectMocks
    private UserManagmentService userManagmentService;
    @Mock
    private UserManagmentRepository userManagmentRepository;

    @Test
    void should CreateUserCorrectly() {
        //given
        var user = someUser();
        when(userManagmentRepository.findByEmail(user.getEmail()))
                .thenReturn(Optional.empty())
                .thenReturn(Optional.of(user));
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
        when(userManagmentRepository.findByEmail(user1.getEmail()))
                .thenReturn(Optional.empty())
                .thenReturn(Optional.of(user1));
        when(userManagmentRepository.findByEmail(user2.getEmail()))
                .thenReturn(Optional.empty())
                .thenReturn(Optional.of(user2));
        when(userManagmentRepository.findByEmail(user3.getEmail()))
                .thenReturn(Optional.empty())
                .thenReturn(Optional.of(user3));
        when(userManagmentRepository.findAll().thenReturn(List.of(user1,user2,user3)));

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
        Assertions.assertEquals(user2,result2.get());
        Assertions.assertTrue(result3.isPresent());
        Assertions.assertEquals(user3,result3.get());
    }

    @Test
    void shouldFailWhenDuplicatedUserIsCreated() {
        //given
        String duplicatedEmail = "someemail@gmail.com";
        var user1 = someUser().withEmail(duplicatedEmail);
        var user2 = someUser().withEmail(duplicatedEmail);
        when(userManagmentRepository.findByEmail(duplicatedEmail))
                .thenReturn(Optional.empty())
                .thenThrow(new RuntimeException(String.format("User with email: [%s] is already created", user1.getEmail())));

        //when, then
        userManagmentService.create(user1);
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> userManagmentService.create(user2));
        Assertions.assertEquals(String.format("User with email: [%s] already created". user1.getEmail(), exception.getMessage()));
    }

    @Test
    void shouldFailWhenAddingUsersToRepositoryFails() {
        //given
        String errorMessage = "Error while creating user";
        var user = someUser();
        when(userManagmentRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        doThrow(new RuntimeException(errorMessage)).when(userManagmentRepository).create(user);

        //when, then
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> userManagmentService.create(user));
        Assertions.assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void shouldFindUserWithName() {
        //given
        var user1 = somneUser().withEmail("email1@gmail.com");
        var user2 = somneUser().withEmail("email2@gmail.com");
        var user3 = somneUser().withName("newName").withEmail("email3@gmail.com");
        when(userManagmentRepository.findByName(user1.getName())).thenReturn(List.of(user1,iser2));
        when(userManagmentRepository.findByName(user3.getName())).thenReturn(List.of(user3));
        when(userManagmentRepository.findAll()).thenReturn(List.of(user1,user2,user3));

        //when
        var result1 = userManagmentService.findByName(user1.getName());
        var result2 = userManagmentService.findByName(user2.getName());
        var result3 = userManagmentService.findByName(user3.getName());
        var all userManagmentService.findAll();

        //then
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
        String email1 = "email1@Gmail.com";
        String email2 = "email2@Gmail.com";
        String email3 = "email3@Gmail.com";
        String emailNew = "newEmail@gmail.com";
        var user1 = someUser().withEmail(email1);
        var user2 = someUser().withEmail(email2);
        var user3 = someUser().withEmail(email3);

        when(userManagmentRepository.findByEmail(email))
                .thenReturn(Optional.empty())
                .thenReturn(Optional.of(user1))
                .thenReturn(Optional.of(user1))
                .thenReturn(Optional.empty());
        when(userManagmentRepository.findByEmail(email2))
                .thenReturn(Optional.empty())
                .thenReturnOptional.of(user2);
        when(userManagmentRepository.findByEmail(emailNew))
                .thenReturn(Optional.of(user1.withEmail(emailNew)));
        when(userManagmentRepository.findAll()).thenReturn(List.of(user1,user2,user3));

        //when
        userManagmentService.create(user1);
        userManagmentService.create(user2);
        userManagmentService.create(user3);

        var all = userManagmentService.findAll();
        Assertions.assertEquals(3, all.size());

        var result1 = userManagmentService.findByEmail(user1.getEmail());
        userManagmentService.update(user1.getEmail(), user1.withEmail(emailNew));
        var result2 = userManagmentService.findByEmail(user1.getEmail());
        var result3 = userManagmentService.findByEmail(emailNew);
        var allAgain = userManagmentService.findAll();

        //then
        Assertions.assertEquals(3, allAgain.size());
        Assertions.assertTrue(result1.isPresent());
        Assertions.assertEquals(user1, result1.get());
        Assertions.assertTrue(result2.isEmpty());
        Assertions.assertTrue(result3.isPresent());
        Assertions.assertEquals(user1.withEmail(emailNew), result3.get());
    }

    @Test
    void shoudlThrowWhenModifyingNonExistingUser() {
        //given
    }
}
