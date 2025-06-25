package Task;

import java.time.LocalDate;
import java.util.Date;

public class Task {

    private boolean completed;
    private String taskName;
    private String description;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    private LocalDate date;


    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getTaskName() {
        return taskName;
    }

    @Override
    public String toString() {
        return "Task{" +
                "completed=" + completed +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Task(String taskName, String description) {
        this.completed = false;
        this.taskName = taskName;
        this.description = description;
    }

    public void complete() {
        this.completed = true;
    }

}
