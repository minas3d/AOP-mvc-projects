package com.example.Exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String id) {
        super("Task not found: " + id);
    }



}
