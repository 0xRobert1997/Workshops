package Workshops.no1_genercis_and_collections.advanced_collections.Exercises.Project;

import java.util.Objects;

public class Person {

    private final String name;
    private final String surname;
    private final Integer counter;
    private final String id;
    private Boolean isVip;

    public Person(String name, String surname, Integer counter) {
        this(name, surname, counter, false);
    }

    public Person(String name, String surname, Integer counter, Boolean isVip) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
        this.isVip = isVip;
        this.id = generateId();
    }

    private String generateId() {
        return this.isVip
                ? String.format("%s_%s_%s_VIP", this.name, this.surname, this.counter)
                : String.format("%s_%s_%s", this.name, this.surname, this.counter);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;

        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
