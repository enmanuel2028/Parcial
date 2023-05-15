/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.todo.test.View;

import com.todo.Controller.Controller;
import com.todo.Model.Book;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 000502339
 */
public class View {
    
 private ByteArrayOutputStream outContent;
    private LibraryView view;

    @BeforeEach
    public void setup() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        view = new LibraryView();
    }

    @Test
    public void testDisplayMenu() {
        view.displayMenu();
        String expectedOutput = "1. Show books\n2. Add book\n3. Remove book\n4. Quit\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShowBooks() {
        LibraryController controller = new LibraryController();
        String title = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";
        String publisher = "Scribner";
        controller.addBook(title, author, publisher);
        view.showBooks();
        String expectedOutput = title + " by " + author + " (" + publisher + ")\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testAddBook() {
        Controller controller = new Controller();
        String title = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";
        String publisher = "Scribner";
        String input = title + "\n" + author + "\n" + publisher + "\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        view = new View();
        view.addBook();
        List<Book> books = controller.getBooks();
        assertEquals(1, books.size());
        Book book = books.get(0);
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(publisher, book.getPublisher());
    }

    @Test
    public void testRemoveBook() {
        Controller controller = new Controller();
        String title = "To Kill a Mockingbird";
        String author = "Harper Lee";
        String publisher = "J. B. Lippincott & Co.";
        controller.addBook(title, author, publisher);
        String input = title + "\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        view = new View();
        view.removeBook();
        List<Book> books = controller.getBooks();
        assertEquals(0, books.size());
    }

    @Test
    public void testRun()
}
