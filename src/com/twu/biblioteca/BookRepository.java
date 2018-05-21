package com.twu.biblioteca;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BookRepository {

    private HashMap<String, Book> bookMap = new HashMap<>();

    public List<Book> bookList = Arrays.asList(
            new Book("Book1", "Mary", "1990"),
            new Book("Book2", "Amy", "2004"),
            new Book("Book3", "Bob", "1999"),
            new Book("Book4", "Lucy", "1988"),
            new Book("Book5", "Jerry", "2000"),
            new Book("Book6", "Mike", "2012")
    );

    public BookRepository() {
        bookList.stream()
                .forEach(book -> bookMap.put(book.getName(), book));
    }

    public HashMap<String, Book> getBookMap() {
        return bookMap;
    }

    public void checkoutBook(String bookName) {

        Book book = bookMap.get(bookName);

        if (book == null || !book.isAvailable()) {
            System.out.println("That book is not available.");
            return;
        }

        book.setAvailable(false);

        bookMap.put(bookName, book);

        System.out.println("Thank you! Enjoy the book");
    }

    public void returnBook(String bookName) {

        Book book = bookMap.get(bookName);

        if (book == null || book.isAvailable()) {
            System.out.println("That is not a valid book to return.");
            return;
        }

        book.setAvailable(true);

        bookMap.put(bookName, book);

        System.out.println("Thank you for returning the book.");
    }
}
