package Workshops.no1_genercis_and_collections.advanced_collections.Exercises.Project;

public class PersonCommandProcessor {

    private final CustomQueue<Person> customQueue;

    public PersonCommandProcessor(CustomQueue<Person> customQueue) {
        this.customQueue = customQueue;
    }

    public void processCommand(String command) {
        if (command.contains("VIP")) {
            handleVipPerson(command);
        } else if (command.contains("ADD PERSON")) {
            handleAddPerson(command);
        } else if (command.contains("LEAVE PERSON")) {
            handleLeavePerson(command);
        } else if (command.contains("PROCESS")) {
            handleProcess(command);
        } else {
            throw new RuntimeException("O co chodzi?");
        }
    }

    private void handleVipPerson(String command) {
        System.out.println(command);
        Person incomingPerson = createPerson(command);
        customQueue.welcomeVip(incomingPerson);
    }

    private void handleAddPerson(String command) {
        String personKey = command.substring(11);
        personKey = personKey.replace(")", "");

        String[] split = personKey.split("_");

        if (split.length != 2) {
            throw new RuntimeException("O co chodzi?");
        }

        String name = split[0];
        String surname = split[1];

        Integer counter = customQueue.getAndIncreaseCounter(personKey);

        System.out.println(command);

        customQueue.welcome(new Person(name, surname, counter));

    }

    private void handleLeavePerson(String command) {
        System.out.println(command);
        String personId = command
                .replace("LEAVE PERSON(", "")
                        .replace(")", "");

        Person person = createPerson(command);
        customQueue.leave(person);

    }

    private static Person createPerson(String command) {
        String personId = command
                .replace("LEAVE PERSON(", "")
                .replace(")", "");


        String[] splitId = personId.split("_");

        if (splitId.length == 2) {
            return new Person(splitId[0], splitId[1], 1);
        } else {
            return new Person(splitId[0], splitId[1], Integer.valueOf(splitId[2]));
        }

    }

    private void handleProcess(String command) {
        System.out.println(command);
        customQueue.enter();
    }
}
