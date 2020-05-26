package main.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TaskDTO {
    private long id;

    @NotNull(message = "Name of Task cannot be empty")
    @NotEmpty(message = "Name of Task cannot be empty")
    private String taskName;
    @NotNull(message = "Description of Task cannot be empty")
    @NotEmpty(message = "Description of Task cannot be empty")
    private String taskDescription;
    @NotNull(message = "Date and time of Task cannot be empty")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime taskDue;
    private static final String DATE_FORMATTER = "dd-MM-yyyy HH:mm";


    public LocalDateTime getTaskDue() {
        return taskDue;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskDue(LocalDateTime taskDue) {
        this.taskDue = taskDue;
    }

    public void setTaskDue(String taskDue){
        this.taskDue = LocalDateTime.parse(taskDue);
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
