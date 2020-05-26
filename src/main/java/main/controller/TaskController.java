package main.controller;

import main.dto.SubtaskDTO;
import main.dto.TaskDTO;
import main.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService= taskService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/tasks";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(Model model, @PathVariable("id") int id) {
        model.addAttribute("task", taskService.getTaskDTO(id));
        model.addAttribute("subtasks", taskService.getSubtasks(id));
        return "task";
    }

    @GetMapping("/tasks/new")
    public String getAddTask(Model model) {
        model.addAttribute("taskDTO", new TaskDTO());
        return "newtask";
    }

    @PostMapping("/tasks/new")
    public String addTask(@ModelAttribute @Valid TaskDTO task, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "newtask";
        }
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("tasks/edit/{id}")
    public String editTaskPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("task", taskService.getTaskDTO(id));
        return "edittask";
    }

    @PostMapping("/tasks/edit/{id}")
    public String editTask(@ModelAttribute TaskDTO task, @PathVariable("id") int id) {
        taskService.editTask(id, task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String showSubtask(Model model, @PathVariable("id") int id){
        model.addAttribute("task",taskService.getTaskDTO(id));
        model.addAttribute("subtask", new SubtaskDTO());
        return "newsubtask";
    }

    @PostMapping("/tasks/{id}/sub/create")
    public String addSubtask(@ModelAttribute SubtaskDTO subTask, @PathVariable("id") int id, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "newsubtask";
        }
        taskService.addSubtask(taskService.getTask(id),subTask);
        return "redirect:/tasks/"+ id;
    }
}
