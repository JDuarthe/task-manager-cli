package com.duartexd.taskmanager;

import java.util.Scanner;

import com.duartexd.taskmanager.service.TaskService;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        TaskService service = new TaskService();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to tasks manager");

        while (true) {
            System.out.println("\n1. Add task\n2. Show tasks\n3. Complete task\n4. Delete task\n5. Exit");
            System.out.print("Pick an option: ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Task title: ");
                    service.addTask(scanner.nextLine());
                    break;
                
                case "2":
                    var tasks = service.getAllTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("There is no tasks.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + ". " + tasks.get(i));
                        }
                    }
                    break;

                case "3":
                    System.out.print("Task's index to complete: ");
                    service.markTaskAsCompleted(Integer.parseInt(scanner.nextLine()));
                    break;
                
                case "4":
                    System.out.print("Task's index to delete: ");
                    service.removeTask(Integer.parseInt(scanner.nextLine()));
                    break;
                
                case "5":
                    System.out.println("Bye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("No valid option");
            }
        }
    }
}
