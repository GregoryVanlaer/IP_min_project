package main.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Subtask {

    @Id
    @GeneratedValue
    private long id;
    @NotNull(message = "Name of task or description cannot be empty")
    @NotEmpty(message = "Name of task cannot or description cannot be empty")
    private String taskName, taskDescription;

//    public Subtask(Task task,String taskName, String taskDescription){
//        setTaskName(taskName);
//        setTaskDescription(taskDescription);
//    }
//
//    public Subtask(){
//
//    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskName() {
        return taskName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String toString(){
        return taskName + ": " + taskDescription;
    }

}
