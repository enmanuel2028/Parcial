/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todo.View;

import com.todo.Controller.Controller;
import com.todo.Model.Book;
import java.util.Scanner;

/**
 *
 * @author 000502339
 */
public class View {
    private Scanner scanner;
    private Controller controller;

    public View() {
        this.scanner = new Scanner(System.in);
        this.controller = new Controller();
    }

    public void displayMenu() {
        System.out.println("1. Show books");
        System.out.println("2. Add book");
        System.out.println("3. Remove book");
        System.out.println("4. Quit");
    }

    public void showBooks() {
        for (Book book : controller.getBooks()) {
            System.out.printf("%s by %s (%s)\n", book.getTitle(), book.getAuthor(), book.getPublisher());
        }
    }

    public void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        controller.addBook(title, author, publisher);
    }

    public void removeBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        controller.removeBook(title);
    }

    public void run() {
        boolean quit = false;
        while (!quit) {
            displayMenu();
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    showBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
