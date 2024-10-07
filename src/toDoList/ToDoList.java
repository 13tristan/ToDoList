package toDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private Scanner scanner = new Scanner(System.in); // Scanner to read input
    private ArrayList<String> arrTodo = new ArrayList<>(); // ArrayList to store to-dos

    public void addToDo() {
        boolean isAdding = true;

        while (isAdding) {
            System.out.println("\nEnter your to-do:");
            System.out.print("-> ");
            String userTodo = scanner.nextLine();

            // Store the to-do in the ArrayList
            arrTodo.add(userTodo);
            System.out.println("To-do added!");

            // Ask if the user wants to add another item
            System.out.println("1 to add another to-do");
            System.out.print("-> ");
            String input = scanner.nextLine();



            // Control flow based on user input
            if (!input.equals("1")) {
                System.out.println("Exiting...");
                System.out.println("Please enter");
                scanner.nextLine();
                return;
            }
        }
    }

    public void viewToDo() {
        if (arrTodo.isEmpty()) {
            System.out.println("\nNo to-do list! You must add items first.");
            scanner.nextLine();
            return;
        } else {
            StringBuilder todos = new StringBuilder();
            for (int i = 0; i < arrTodo.size(); i++) {
                todos.append((i + 1)).append(". ").append(arrTodo.get(i)).append("\n");
            }

            System.out.println("YOUR TO DO'S");
            System.out.println("\n" + todos);
        }
    }

    public void removeToDo() {
        while (true) {
            if (arrTodo.isEmpty()) {
                System.out.println("\nNo to-do list! You must add items first.");
                scanner.nextLine(); // Wait for user to press Enter
                return; // Exit the method to return to the main menu
            } else {
                // Display the current to-do list
                viewToDo();

                System.out.println("1 to remove a to-do by list number");
                System.out.println("2 to remove all");
                System.out.print("-> ");

                int userChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline

                if (userChoice == 2) {
                    removeAllTodos();
                    return; // Exit after removing all
                } else if (userChoice == 1) {
                    removeSingleTodo();
                    return;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private void removeSingleTodo() {
        int index = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Enter the number of the to-do to remove:");
            System.out.print("-> ");
            try {
                index = Integer.parseInt(scanner.nextLine());
                if (index < 1 || index > arrTodo.size()) {
                    System.out.println("Invalid index. Please enter a number between 1 and " + arrTodo.size());
                } else {
                    validInput = true; // Valid input received
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Remove the item at the specified index
        arrTodo.remove(index - 1);
        System.out.println("To-do removed!");
        return;
    }

    private void removeAllTodos() {
        arrTodo.clear(); // Clear all items in the list
        System.out.println("All to-do's removed!");
        scanner.nextLine(); // Wait for user to press Enter to go back to the main menu
    }
}
