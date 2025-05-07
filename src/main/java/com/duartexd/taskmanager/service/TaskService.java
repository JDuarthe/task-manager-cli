package com.duartexd.taskmanager.service;

import com.duartexd.taskmanager.model.Task;
import com.duartexd.taskmanager.storage.FileStorage;

import java.util.List;

public class TaskService {
    private FileStorage storage = new FileStorage();
    private final List<Task> tasks;

    public TaskService() {
        this.tasks = storage.loadTasks();
    }

    public void addTask(String title) {
        tasks.add(new Task(title));
        storage.saveTasks(tasks);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).complete();
        } else {
            System.out.println("Wrong index.");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            storage.saveTasks(tasks);
        } else {
            System.out.println("Wrong index.");
        }
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}
