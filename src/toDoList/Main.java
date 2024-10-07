package toDoList;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Scanner Object
        Scanner scanner = new Scanner(System.in);
        ToDoList todo = new ToDoList();

        //Logic to control the flow\\
        boolean isChoosing = true;
        while (isChoosing) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add a To-Do");
            System.out.println("2. View To-Do List");
            System.out.println("3. Remove a To-Do");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    todo.addToDo(); // Call add() method to add a to-do item
                    break;
                case 2:
                    todo.viewToDo();// Call viewToDo() method to display the to-do list
                    break;
                case 3:
                    todo.removeToDo();
                    break; // Exit the loop and end the program
                case 4:
                    System.out.println("Exiting...");
                    isChoosing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }       
}