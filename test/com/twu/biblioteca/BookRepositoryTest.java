package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookRepositoryTest {

    BookRepository bookRepository = new BookRepository();

    @Test
    public void should_return_false_when_book_is_checked_out() {
        Book book = bookRepository.getBookMap().get("Book1");

        bookRepository.checkoutBook("Book1");

        assertFalse(book.isAvailable());
    }

    @Test
    public void should_return_true_when_book_is_not_checked_out() {

        Book book = bookRepository.getBookMap().get("Book1");

        assertTrue(book.isAvailable());
    }

    @Test
    public void should_return_true_when_checkedout_book_is_returned() {

        Book book = bookRepository.getBookMap().get("Book1");

        bookRepository.checkoutBook("Book1");

        bookRepository.returnBook("Book1");

        assertTrue(book.isAvailable());

    }
}