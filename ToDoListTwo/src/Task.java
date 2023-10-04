
import java.util.Iterator;
import java.util.Scanner;

class Task {
    private String taskName;
    private String dueDate;
    private boolean completed;

    public Task(String taskName, String dueDate) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.completed = false; // By default, a task is not completed.
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        return "Task: " + taskName + " | Due Date: " + dueDate + " | Completed: " + (completed ? "Yes" : "No");
    }




    static void addTask(Scanner scanner) {
        System.out.print("Please enter Task Name: ");
        String taskName = scanner.nextLine();
        System.out.print("Please enter Due Date: ");
        String dueDate = scanner.nextLine();

        Task task = new Task(taskName, dueDate);
        TodoListApp.taskList.add(task);
        System.out.println("Task added successfully.");
    }

    static void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter Task Name to mark as completed: ");
        String taskName = scanner.nextLine();

        boolean found = false;
        for (Task task : TodoListApp.taskList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                task.markAsCompleted();
                System.out.println("Task marked as completed.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Task not found.");
        }
    }

    static void listTasks() {
        System.out.println("\nTask List:");
        for (Task task : TodoListApp.taskList) {
            System.out.println(task);
        }
    }

    static void removeCompletedTasks() {
        Iterator<Task> iterator = TodoListApp.taskList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.isCompleted()) {
                iterator.remove();
            }
        }
        System.out.println("Completed tasks removed.");
    }
}
