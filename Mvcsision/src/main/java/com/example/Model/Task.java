package com.example.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Task {
    @NotNull  (message = "Title is required")
    @NotBlank(message = "Id is required")
    private String Id ;
    @NotBlank(message = "Title is required")
    private String Title ;
    @NotNull  (message = "Priority is required")
    private String Priority ;
    public Task() {
    }
    public Task(String id, String title, String priority) {
        setId(id);
        setTitle( title);
        setPriority(priority);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

}




