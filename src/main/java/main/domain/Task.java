package main.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Task  {
    @Id
    @GeneratedValue
    private long id;

    private static int count = 0;
    @NotNull(message = "Name of Task cannot be empty")
    @NotEmpty(message = "Name of Task cannot be empty")
    private String taskName;

    @NotEmpty(message = "Description of Task cannot be empty")
    @NotNull(message = "Description of Task cannot be empty")
    private String taskDescription;

    @NotNull(message = "Date and time of Task cannot be empty")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime taskDue;
    private static final String DATE_FORMATTER = "dd-MM-yyyy HH:mm";

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Subtask> subtasks;

//    public Task(String taskName, String taskDescription, String taskDue){
//        subtasks = new ArrayList<>();
//        setTaskName(taskName);
//        setTaskDescription(taskDescription);
//        setTaskDue(taskDue);
//    }
//
//    public Task(String taskName, String taskDescription, LocalDateTime taskDue){
//        subtasks = new ArrayList<>();
//        setTaskName(taskName);
//        setTaskDescription(taskDescription);
//        setTaskDue(taskDue);
//    }

    public Task(){
        subtasks = new ArrayList<>();
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {

        this.taskDescription = taskDescription;
    }

    public void setTaskDue(String taskDue) {

        this.taskDue = LocalDateTime.parse(taskDue);
    }

    public void setTaskDue(LocalDateTime taskDue) {

        this.taskDue = taskDue;
    }

    public LocalDateTime getTaskDue() {
        return taskDue;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskName() {
        return taskName;
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        return taskName + " - " + taskDescription + " due to " + taskDue.format(formatter);
    }

    public long getId() {
        return id;
    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public void addSubTask(Subtask subTask){
//        long id = 0;
//        if(this.subtasks.size() > 0){
//            id = this.subtasks.get(subtasks.size()-1).getId()+1;
//        }
//        subTask.setId(id);
        this.subtasks.add(subTask);
    }
}