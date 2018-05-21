package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BookRepositoryTest {

    private BookRepository bookRepository = new BookRepository();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void should_print_msg_for_successful_checkout() {
        bookRepository.checkoutBook("Book1");

        assertEquals("Thank you! Enjoy the book.\n", outContent.toString());
    }

    @Test
    public void should_print_msg_for_unsuccessful_checkout() {
        bookRepository.checkoutBook("Book123");

        assertEquals("That book is not available.\n", outContent.toString());
    }

    @Test
    public void should_print_msg_for_successful_return() {
        bookRepository.checkoutBook("Book1");

        bookRepository.returnBook("Book1");

        assertEquals("Thank you! Enjoy the book.\nThank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void should_print_msg_for_unsuccessful_return() {
        bookRepository.returnBook("Book123");

        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }


    @Test
    public void should_return_true_when_book_is_not_checked_out() {

        Book book = bookRepository.getBookMap().get("Book1");

        assertTrue(book.isAvailable());
    }

    @Test
    public void should_return_false_when_checked_out_and_return_true_when_returned() {

        Book book = bookRepository.getBookMap().get("Book1");

        bookRepository.checkoutBook("Book1");

        assertFalse(book.isAvailable());

        bookRepository.returnBook("Book1");

        assertTrue(book.isAvailable());
    }

}