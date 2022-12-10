package Workshops.no1_genercis_and_collections.advanced_collections.Project;

public class Person {

    private final String name;
    private final String surname;
    private final Integer counter;

    public Person(String name, String surname, Integer counter) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
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
        return "{" + name  + surname + counter + '}';
    }
}
