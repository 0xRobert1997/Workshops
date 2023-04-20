package Workshops.no3_localization_and_files.Exercises.project.domain;

public class Person {

    private String firstName;
    private String lastName;
    private String email;
    private String ip;

    public Person(String firstName, String lastName, String email, String ip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ip = ip;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
