package com.example.Repo;

import com.example.Model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TaskRepo {



    List<Task> tasks = new ArrayList<>();

    public TaskRepo() {
        tasks.add(new Task("1", "Learn Spring", "High"));
        tasks.add(new Task("2", "Learn MVC", "Medium"));
        tasks.add(new Task("3", "Build Project", "High"));
        tasks.add(new Task("4", "Practice Validation", "Low"));
        tasks.add(new Task("5", "Study Hibernate", "Medium"));
    }
    public  void addTAsk (Task task){
        tasks.add(task);
    }
    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }
    public  Task findByID(String id)
    {
        for (Task t : tasks)
        {
            if (t.getId().equals(id))
            {
                return t;
            }

        }

        return null;
    }
    public List<Task> findByPriority(String priority)
    {
        List<Task> res= new ArrayList<>();
        for (Task t : tasks)
        {
            if (t.getPriority().equals(priority))
            {
                res.add(t);
            }

        }

        return res;
    }
}
