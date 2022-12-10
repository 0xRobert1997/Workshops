package Workshops.no1_genercis_and_collections.advanced_collections.Exercises.Project;

public class CommandProcessor {

    private final CustomQueue<Person> customQueue;

    public CommandProcessor(CustomQueue<Person> customQueue) {
        this.customQueue = customQueue;
    }

    public void processCommand(String command) {
        if (command.contains("ADD PERSON")) {
            handleAddPerson(command);
        } else if (command.contains("LEAVE PERSON")) {
            handleLeavePerson(command);
        } else if (command.contains("PROCESS")) {
            handleProcess(command);
        } else {
            throw new RuntimeException("O co chodzi?");
        }
    }

    private void handleAddPerson(String command) {
        command = command.substring(11);
        command = command.replace(")", "");

        String personKey = command;

        String[] split = command.split("_");

        if (split.length != 2) {
            throw new RuntimeException("O co chodzi?");
        }

        String name = split[0];
        String surname = split[1];

        Integer counter = getAndIncreaseCounter(personKey);

        System.out.println(name + " " + surname + " " + counter);

        queue.offer(new Person(name, surname, counter));

    }

    private Integer getAndIncreaseCounter(String personKey) {
        Integer tempCounter = counterMap.getOrDefault(personKey, 0);
        counterMap.put(personKey, ++tempCounter);
        return tempCounter;
    }

    private void handleLeavePerson(String command) {

    }

    private void handleProcess(String command) {

    }
}
