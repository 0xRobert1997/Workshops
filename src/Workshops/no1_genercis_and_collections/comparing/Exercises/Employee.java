package Workshops.no1_genercis_and_collections.comparing.Exercises;

import java.math.BigDecimal;

public class Employee implements Comparable<Employee>{

    private final String name;
    private final String surname;
    private final Integer age;
    private final BigDecimal salary;


    public Employee(String name, String surname, int age, BigDecimal salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    }


    @Override
    public int compareTo(Employee o) {
        int comapreByName = this.name.compareTo(o.name);
        if (comapreByName != 0) {
            return comapreByName;
        }

        int compareBySurname = o.surname.compareTo(this.surname);
        if (compareBySurname != 0) {
            return compareBySurname;
        }

        int compareByAge = this.age.compareTo(o.age);
        if (compareByAge != 0) {
            return compareByAge;
        }

        int compareBySalary = o.salary.compareTo(this.salary);
        if (compareBySalary != 0) {
            return compareBySalary;
        }

        return 0;
    }

    @Override
    public String toString() {
        return  "[" + name + " " +
               surname + " " + age + " " + salary + "]";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
