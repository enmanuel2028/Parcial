/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todo.Controller;
import com.todo.Model.Book;
import com.todo.Model.Model;
import java.util.List;

/**
 *
 * @author 000502339
 */
public class Controller {
 private Model library;

    public Controller() {
        this.library = new Model();
    }
//Se añaden los libros
    public void addBook(String title, String author, String publisher) {
        Book book = new Book(title, author, publisher);
        library.addBook(book);
    }
 
//Hay un error en recorrer el arraylist
    public void removeBook(String title) {
        List<Book> books = library.getBooks();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                library.removeBook(book);
                return;
            }
        }
    }
 //Arreglar el print
 
    public List<java.awt.print.Book> getBooks() {
        return library.getBooks();
    }
}
