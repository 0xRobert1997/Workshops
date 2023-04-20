package Workshops.no4_databases.jdbcProject;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class TodoApp {
    public static void startToDoApp() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, insert command or \"exit\" if u want to exit: ");
        String inputCommand = scanner.nextLine();
       // String inputCommand = "READ ALL;SORT=PRIORITY,DESC";

        if (inputCommand.contains("CREATE")
                || (inputCommand.contains("UPDATE"))
                || (inputCommand.contains("READ"))
                || (inputCommand.contains("DELETE"))
                || (inputCommand.contains("COMPLETED"))
        ) {
            String generatedCommand = generateSqlCommand(inputCommand);
            String queryType = getQueryType(generatedCommand);

            connectToDatabase(generatedCommand, queryType);

            startToDoApp();

        } else if (inputCommand.equals("exit")) {
            return;
        } else {
            System.out.println("Please insert correct command or \"exit\" if u want to exit");
            startToDoApp();
        }
    }

    private static String getQueryType(String command) {

        if (command.contains("INSERT")) {
            return "insert";
        } else if (command.contains("UPDATE")) {
            return "update";
        } else if (command.contains("DELETE")) {
            return "delete";
        } else {
            return "select";
        }

    }

    private static String generateSqlCommand(String command) {

        String[] stringsTable = splitInsertedCommand(command);
        String headOfInsertedCommand = stringsTable[0];

        boolean isToSort = false;
        if (stringsTable.length >1) {
            isToSort = stringsTable[1].contains("SORT");
        }

        String readyCommand = null;

        if (headOfInsertedCommand.contains("CREATE")) {
            readyCommand = generateInsertCommand(stringsTable);
        } else if (headOfInsertedCommand.contains("UPDATE")) {
            readyCommand = generateUpdateCommand(stringsTable);
        } else if (isToSort) {
            readyCommand = generateSortedSelectAllCommand(stringsTable);
        } else if (headOfInsertedCommand.contains("READ ALL")) {
            readyCommand = generateSelectAllCommand(stringsTable);
        } else if (headOfInsertedCommand.contains("READ GROUPED")) {
            readyCommand =  "SELECT * FROM TASKS GROUP BY DATE(DEADLINE), NAME";
        }else if (headOfInsertedCommand.contains("READ")) {
            readyCommand = generateSelectCommand(stringsTable);
        } else if (headOfInsertedCommand.contains("DELETE")) {
            readyCommand = generateDeleteCommand(stringsTable);
        } else if (headOfInsertedCommand.contains("COMPLETED")) {
            readyCommand = generateMarkingAsCompleteCommand(stringsTable);
        } else {
            throw new RuntimeException("Wrong command");
        }


        return readyCommand;
    }

    private static String generateMarkingAsCompleteCommand(String[] stringsTable) {
        String name = stringsTable[1].substring(5);

        return "UPDATE TASKS SET STATUS = 'COMPLETED' WHERE NAME = '" + name + "'";
    }

    private static String generateInsertCommand(String[] stringsTable) {

        String NAME = stringsTable[1].substring(5);
        String DESCRIPTION = stringsTable[2].substring(12);
        String DEADLINE = stringsTable[3].substring(9);
        int PRIORITY = Integer.parseInt(stringsTable[4].replace(" ", "").substring(9));
        String comma = ", ";

        return "INSERT INTO TASKS(NAME, DESCRIPTION, DEADLINE, PRIORITY) VALUES (" +
                '\'' + NAME + '\'' + comma
                + '\'' + DESCRIPTION + '\'' + comma
                + '\'' + DEADLINE + '\'' + comma
                + PRIORITY
                + ");";
    }

    private static String generateUpdateCommand(String[] stringsTable) {

        String NAME = stringsTable[1].substring(5);
        String DESCRIPTION = stringsTable[2].substring(12);
        String DEADLINE = stringsTable[3].substring(9);
        int PRIORITY = Integer.parseInt(stringsTable[4].replace(" ", "").substring(9));

        return "UPDATE TASKS SET DESCRIPTION = '" + DESCRIPTION + "', DEADLINE = '" + DEADLINE + "', PRIORITY = "
                + PRIORITY + " WHERE NAME = '" + NAME + "';";
    }

    private static String generateSortedSelectAllCommand(String[] stringsTable) {
        String sortParam = "";

        if (stringsTable[1].contains("NAME")) {
            sortParam = "NAME";
        } else if (stringsTable[1].contains("DEADLINE")) {
            sortParam = "DEADLINE";
        } else if (stringsTable[1].contains("PRIORITY")) {
            sortParam = "PRIORITY";
        }

        if (stringsTable[1].contains("DESC")) {
            return "SELECT * FROM TASKS ORDER BY " + sortParam + " DESC";
        }

        return "SELECT * FROM TASKS ORDER BY " + sortParam;
    }

    private static String generateSelectAllCommand(String[] stringsTable) {
        return "SELECT * FROM TASKS";
    }

    private static String generateSelectCommand(String[] stringsTable) {
        String NAME = stringsTable[1].substring(5);
        return "SELECT * FROM TASKS WHERE NAME = '" + NAME + "'";
    }

    private static String generateDeleteCommand(String[] stringsTable) {
        String NAME = stringsTable[1].substring(5);
        return "DELETE FROM TASKS WHERE NAME = '" + NAME + "';";
    }

    private static String[] splitInsertedCommand(String s) {
        return s.split(";");
    }

    private static void connectToDatabase(String query, String queryType) {
        String address = "jdbc:postgresql://127.0.0.1:5432/todo";
        String username = "postgres";
        String password = "postgres";

        try (
                Connection connection = DriverManager.getConnection(address, username, password);
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {

            switch (queryType) {
                case "insert":
                    preparedStatement.executeUpdate();
                    System.out.println("Tasks sucessfully inserted");
                    break;
                case "delete":
                    preparedStatement.executeUpdate();
                    System.out.println("Tasks sucessfully deleted");
                    break;
                case "update":
                    preparedStatement.executeUpdate();
                    System.out.println("Tasks sucessfully updated");
                    break;
                case "select":
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        List<Task> tasks = TaskMapper.mapToTask(resultSet);

                        tasks.forEach(System.out::println);
                        System.out.println();
                    }
                    break;
            }

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }


}
