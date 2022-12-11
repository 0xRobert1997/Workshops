package Workshops.no1_genercis_and_collections.comparing.Exercises;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> exerciseList = Arrays.asList(
                new Employee("Dariusz","Dodawski", 32, BigDecimal.valueOf(98000)),
                new Employee("Bartek","Bbaski", 222, BigDecimal.valueOf(18000)),
                new Employee("Cecyliusz","Ctrzysaski", 28, BigDecimal.valueOf(22000)),
                new Employee("Jozek","Jajkowski", 29, BigDecimal.valueOf(8050)),
                new Employee("Emil","Ewelski", 42, BigDecimal.valueOf(8600)),
                new Employee("Galileusz","Galganski", 102, BigDecimal.valueOf(4000)),
                new Employee("Filip","Fifalski", 72, BigDecimal.valueOf(5000)),
                new Employee("Adam","Aaski", 22, BigDecimal.valueOf(8000)),
                new Employee("Horacy","Himalajski", 223, BigDecimal.valueOf(3000)),
                new Employee("Ireneusz","Inflacyjny", 27, BigDecimal.valueOf(9000))
        );

        print(exerciseList);


        // Comparable
        Collections.sort(exerciseList);



        // Comparator
        Comparator<Employee> ComparingByName = Comparator.comparing(employee -> employee.getName());
        Comparator<Employee> ComparingBySurname = Comparator.comparing(employee -> employee.getSurname());
        Comparator<Employee> ComparingByAge = Comparator.comparing(employee -> employee.getAge());
        Comparator<Employee> ComparingBySalary = Comparator.comparing(employee -> employee.getSalary());


       exerciseList.sort(
                ComparingByName.reversed()
                        .thenComparing(ComparingBySurname).reversed()
                        .thenComparing(ComparingByAge)
                        .thenComparing(ComparingBySalary).reversed()
        );

        print(exerciseList);


    }

    private static void print(List<Employee> employeeList) {
        System.out.println("####");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        System.out.println();
        System.out.println();
    }




}
