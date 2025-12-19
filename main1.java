// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Scanner;

public class main1 {
    private static String[] taskTitles = new String[50];
    private static String[] taskDescriptions = new String[50];
    private static String[] taskStatuses = new String[50];
    private static String[] studentNames = new String[50];
    private static int taskCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printWelcome();
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    addTask();
                    break;
                case "2":
                    viewTask();
                    break;
                case "3":
                    searchTask();
                    break;
                case "4": 
                    updateTaskStatus();
                    break;
                case "5":    
                    running = false;
                    System.out.println("Thank you for using the Task Management System.");
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please enter 1, 2, 3, or 4.\n");
            }
        }

        scanner.close();
    }

    private static void printWelcome() {
        System.out.println("\n**************");
        System.out.println("Welcome to Student Task and Progress Management");
        System.out.println("**************");
    }

    private static void displayMenu() {
        System.out.println("\nTASK MANAGEMENT MENU");
        System.out.println("\n**************");
        System.out.println("1. Add Task");
        System.out.println("2. View Task");
        System.out.println("3. Search Task");
        System.out.println("4. UpdateTaskStatus");
        System.out.println("5. Exit");
        System.out.println("**************");
    }

    private static String addTask(String title, String studentName) {
        if (taskCount >= 50) {
            return "Error: Task Storage is full!";
        }
        taskTitles[taskCount] = title;
        taskDescriptions[taskCount] = "No description";
        taskStatuses[taskCount] = "pending";
        studentNames[taskCount] = studentName;
        taskCount++;
        return "Task added successfully!";
    }

    private static String addTask(String title, String description, String studentName) {
        if (taskCount >= 50) {
            return "Error: Task Storage is full!";
        }
        taskTitles[taskCount] = "title";
        taskDescriptions[taskCount] = "description";
        taskStatuses[taskCount] = "pending";
        studentNames[taskCount] = "studentName";
        taskCount++;
        return "Task added successfully with description!";
    }

    private static void addTask() {
        System.out.println("\nAdd New Task");
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter Task Title: ");
        String taskTitle = scanner.nextLine();
        System.out.print("Enter Description (or press Enter to skip): ");
        String description = scanner.nextLine();

        String result;
        if (description.isEmpty()) {
            result = addTask(taskTitle, studentName);
        } 
        else {
            result = addTask(taskTitle, description, studentName);
        }
        System.out.println("\n" + result + "\n");
    }

    private static void viewTask() {
        System.out.println("\nAll tasks:");
        if (taskCount == 0) {
            System.out.println("No tasks found. Add some tasks first!\n");
            return;
        }
        for (int i = 0; i < taskCount; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i + 1).append(". ");
            sb.append("[").append(taskStatuses[i]).append("] ");
            sb.append(taskTitles[i]);
            sb.append(" - ").append(studentNames[i]);
            System.out.println(sb.toString());

            if (!taskDescriptions[i].equals("No description")) {
                System.out.println("Description: " + taskDescriptions[i]);
            }
        }
        System.out.println("\nTotal Tasks: " + taskCount + "\n");
    }

    private static void searchTask() {
        System.out.println("\nSearch Tasks");
        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine().toLowerCase();
        System.out.println("Search Results for '" + keyword + "' __");

        int found = 0;
        for (int i = 0; i < taskCount; i++) {
            if (taskTitles[i].toLowerCase().contains(keyword) ||
                taskDescriptions[i].toLowerCase().contains(keyword) ||
                studentNames[i].toLowerCase().contains(keyword)) {
                System.out.println((i + 1) + ". [" + taskStatuses[i] + "] " + taskTitles[i] + " - " + studentNames[i]);
                found++;
            }
        }

        if (found == 0) {
            System.out.println("No tasks found matching '" + keyword + "'");
        }
        else {
            System.out.println("\nFound " + found + " task(s)");
        }
    }
    private static void updateTaskStatus (){
        System.out.println("\n ---update Task status---");
        if(taskCount==0){
            System.out.println("No tasks to update!\n");
            return;
        }
        viewTask();
        System.out.print("Enter task number to update:");
        String input = scanner.nextLine();
    
            int taskNum=Integer.parseInt(input);
            if(taskNum<1|| taskNum> taskCount){
                System.out.println("Invalid task number!\n");
                return;
            }
            System.out.println("\n select new status:");
            System.out.println("1.pending");
            System.out.println("2.In progress");
            System.out.println("3.completed:");
            System.out.println("Enter choice:");
            String StatusesChoice = scanner . nextLine();
            switch(StatusesChoice){
                case "1" :
                    taskStatuses [taskNum-1] = "pending";
                    break;
                case "2":
                    taskStatuses [taskNum-1] = "In progress";
                    break;
                case "3":
                    taskStatuses [taskNum-1] = "completed";
                    break;
                default:
                    System.out.println("Invalid choice! statuses not updated./n");
                    return;
                }
            System.out.println("Statuses updated successfully\n");
        } 
        


            

                            
            

        

    }
