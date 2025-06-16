/*
 * The ToDoApp uses the methods from ToDoList in a menu to allow the user to
 * create and manage their own to-do list
 */

import entity.Item;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class ToDoApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Scanner sc = new Scanner(System.in);
        Actions dao = new Actions(sessionFactory);
        boolean running = true;

        System.out.println("Welcome to your To-Do List.");

        while (running) {
            System.out.println("\nHere are your options: ");
            System.out.println("1. View to-do list");
            System.out.println("2. Add a new item to the list");
            System.out.println("3. Delete an item from the list");
            System.out.println("4. Exit");

            System.out.println("\nWhat would you like to do? ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    List<Item> items = dao.getAllItems();
                    if (items.isEmpty()) {
                        System.out.println("Your to-do list is empty.");
                    } else {
                        System.out.println("To-Do List:");
                        for (Item item : items) {
                            System.out.println(item.getId() + ". " + item.getDescription());
                        }
                    }
                    break;

                case "2":
                    System.out.print("Enter item description: ");
                    String desc = sc.nextLine();
                    dao.addItem(new Item());
                    System.out.println("Added: " + desc);
                    break;

                case "3":
                    System.out.print("Enter ID to delete: ");
                    try {
                        int id = Integer.parseInt(sc.nextLine());
                        dao.deleteItem(id);
                        System.out.println("Deleted item with ID: " + id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID input.");
                    }
                    break;

                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}