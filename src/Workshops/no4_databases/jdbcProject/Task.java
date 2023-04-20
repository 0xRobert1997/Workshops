package Workshops.no4_databases.jdbcProject;

import java.time.LocalDateTime;

public class Task {

    private String name;
    private String description;
    private LocalDateTime deadline;
    private int priority;
    private String status;

    public Task(String name, String description, LocalDateTime deadline, int priority, String status) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "[" + name + "][" + description + "][" + deadline + "][" + priority + "][" + status + "]";
    }
}
