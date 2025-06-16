/*
 * The ToDoApp uses the methods from ToDoList in a menu to allow the user to
 * create and manage their own to-do list
 */

import entity.Item;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.*;

public class ToDoApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        Scanner sc = new Scanner(System.in);
        Actions actions = new Actions(emf);
        boolean running = true;

        System.out.println("Welcome to your To-Do List.");

        while (running) {
            System.out.println("\nHere are your options: ");
            System.out.println("1. View to-do list");
            System.out.println("2. Add a new item to the list");
            System.out.println("3. Delete item by ID");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    List<Item> items = actions.getAllItems();
                    if (items.isEmpty()) {
                        System.out.println("Your list is empty.");
                    } else {
                        for (Item item : items) {
                            System.out.println(item.getId() + ". " + item.getDescription());
                        }
                    }
                }
                case "2" -> {
                    System.out.print("Enter new item: ");
                    String description = sc.nextLine();
                    actions.addItem(description);
                    System.out.println("Added.");
                }
                case "3" -> {
                    System.out.print("Enter ID to delete: ");
                    try {
                        int id = Integer.parseInt(sc.nextLine());
                        actions.deleteItem(id);
                        System.out.println("Deleted if found.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                    }
                }
                case "4" -> {
                    emf.close();
                    sc.close();
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}