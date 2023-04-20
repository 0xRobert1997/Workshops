package Workshops.no4_databases.jdbcProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskMapper {

    public static List<Task> mapToTask(ResultSet resultSet) {
        List<Task> tasks = new ArrayList<>();

        try {
            while (resultSet.next()) {
                DateTimeFormatter formatterRead = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                DateTimeFormatter formatterWrite = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                // "yyyy-MM-dd HH:mm:ss"
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.applyPattern("dd.MM.yyyy HH:mm");

                tasks.add(new Task(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        LocalDateTime.parse(LocalDateTime.parse(resultSet.getString(3), formatterRead).format(formatterWrite), formatterWrite),
                        resultSet.getInt(4),
                        resultSet.getString(5)
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tasks;
    }
}
