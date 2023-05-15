/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.todo.Model.Book;
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
public class ModeloTest {

 @Test
    public void testGetTitle() {
        String title = "The Great Gatsby";
        Book book = new Book(title, "F. Scott Fitzgerald", "Scribner");
        assertEquals(title, book.getTitle());
    }

    @Test
    public void testGetAuthor() {
        String author = "Harper Lee";
        Book book = new Book("To Kill a Mockingbird", author, "J. B. Lippincott & Co.");
        assertEquals(author, book.getAuthor());
    }

    @Test
    public void testGetPublisher() {
        String publisher = "George Allen & Unwin";
        Book book = new Book("The Lord of the Rings", "J. R. R. Tolkien", publisher);
        assertEquals(publisher, book.getPublisher());
    }
    
}
