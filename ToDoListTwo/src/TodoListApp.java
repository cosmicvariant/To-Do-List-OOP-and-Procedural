import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoListApp {
    static List<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. List Tasks");
            System.out.println("4. Remove Completed Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = myScanner.nextInt();
            myScanner.nextLine();

            switch (choice) {
                case 1:
                    Task.addTask(myScanner);
                    break;

                case 2:
                    Task.markTaskAsCompleted(myScanner);
                    break;

                case 3:
                    Task.listTasks();
                    break;

                case 4:
                    Task.removeCompletedTasks();
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    myScanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

