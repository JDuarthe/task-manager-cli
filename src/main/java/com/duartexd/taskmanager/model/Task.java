package com.duartexd.taskmanager.model;

public class Task {
    private String title;
    private boolean completed;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public void complete() { this.completed = true; }

    public String toString() {
        return (completed ? "[x] " : "[ ] ") + title;
    }
}
