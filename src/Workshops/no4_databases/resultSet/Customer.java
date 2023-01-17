package Workshops.no4_databases;

import java.time.LocalDate;

public class Customer {
    private final String id;
    private final String userName;
    private final String email;
    private final String name;
    private final String surName;
    private final LocalDate dateOfBirth;
    private final String telephoneNumner;

    public Customer(String id, String userName, String email, String name, String surName, LocalDate dateOfBirth, String telephoneNumner) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.telephoneNumner = telephoneNumner;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTelephoneNumner() {
        return telephoneNumner;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", telephoneNumner='" + telephoneNumner + '\'' +
                '}';
    }
}
