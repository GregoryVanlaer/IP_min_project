package main.service;

import main.dto.SubtaskDTO;
import main.domain.Task;
import main.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> getTasks();
    void addTask(TaskDTO taskDTO);
    TaskDTO addTaskAPI(TaskDTO taskDTO);
    Task getTask(long id);
    public TaskDTO getTaskDTO(long id);
    void editTask(long id, TaskDTO taskDTO);
    public List<SubtaskDTO> getSubtasks(long id);
    void addSubtask(Task task, SubtaskDTO subtaskDTO);

}
