package com.example.Controller;

import com.example.Exception.TaskNotFoundException;
import com.example.Model.Task;
import com.example.Repo.TaskRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    TaskRepo taskRepo;

    public TaskController(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }
    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("tasks", taskRepo.findAll());
        return "Home";
    }

    @GetMapping("/showById/{id}")
    public String showById(@PathVariable String id, Model model) {
        Task task = taskRepo.findByID(id);
        if (task == null) throw new TaskNotFoundException(id);
        model.addAttribute("task", task);
        return "TaskDetails";
    }

    @GetMapping("/showByPriority")
    public String showByPriority(@RequestParam(defaultValue = "High") String priority, Model model) {
        model.addAttribute("tasks", taskRepo.findByPriority(priority));
        return "Home";
    }

    @GetMapping("/new")
    public String showForm() {
        return "AddTask";
    }

    @PostMapping("/setData")
    public String addTask(Task t) {
        try {
            taskRepo.addTAsk(t);
            return "Success";
        } catch (Exception e) {
            return "Fail";
        }
    }
}