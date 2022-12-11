package Workshops.no1_genercis_and_collections.advanced_collections.Exercises.Project;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> commands = List.of(
                "ADD PERSON(Tomasz_Romański)",
                        "ADD PERSON(Rafał_Adamczuk)",
                        "ADD PERSON(Tomasz_Romański)",
                        "ADD PERSON(Tomasz_Romański, VIP)",
                        "ADD PERSON(Mariusz_Wilczek)",
                        "ADD PERSON(Zbigniew_Ratownik)",
                        "PROCESS",
                        "LEAVE PERSON(Tomasz_Romański_2)",
                        "LEAVE PERSON(Mariusz_Wilczek)",
                        "PROCESS"
        );

        CustomQueue<Person> queue = new CustomQueue<>(new ArrayDeque<>(), new ArrayDeque<>());
        PersonCommandProcessor personCommandProcessor = new PersonCommandProcessor(queue);

      /*  for (String command : commands) {
            personCommandProcessor.processCommand(command);
        }*/

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.next();
            personCommandProcessor.processCommand(command);
        }
    }
}
