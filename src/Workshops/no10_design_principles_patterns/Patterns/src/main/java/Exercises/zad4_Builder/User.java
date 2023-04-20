package Exercises.zad4_Builder;

public class User {

    private String firstName;
    private String lastName;
    private String email;


    private User(UserBuilder userBuilder) {
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
    }


    public static  UserBuilder builder() {
        return new UserBuilder();
    }

    static class UserBuilder {
        private String firstName;
        private String lastName;
        private String email;

         public UserBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
         public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

         public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
         public User build() {
            return new User(this);
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
