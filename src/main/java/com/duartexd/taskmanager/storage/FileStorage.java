package com.duartexd.taskmanager.storage;

import java.util.ArrayList;
import java.util.List;

import com.duartexd.taskmanager.model.Task;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;

public class FileStorage {
    private static final String FILE_PATH = "tasks.json";
    private final Gson gson = new Gson();

    public List<Task> loadTasks() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (Reader reader = new FileReader(FILE_PATH)){
            Type taskListType = new TypeToken<List<Task>>() {}.getType();
            return gson.fromJson(reader, taskListType);
        } catch (IOException e) {
            System.out.println("Task's load error: " + e.getMessage());
            return new ArrayList<>();
        }
    }


    public void saveTasks(List<Task> tasks) {
        try (Writer writer = new FileWriter(FILE_PATH)){
            gson.toJson(tasks, writer);
        } catch (Exception e) {
            System.out.println("Task's save error: " + e.getMessage());
        }
    }

}
