package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExampleTest {

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
    public void should_display_welcome_message() {
        BibliotecaApp.displayWelcomeMessage();
        assertEquals("Welcome to the Biblioteca!\n", outContent.toString());
    }

    @Test
    public void should_display_main_menu() {
        BibliotecaApp.displayMainMenu();
        assertEquals("Main menu\n1. List Books\nType \"Quit\" to quit the app.\n", outContent.toString());
    }

    @Test
    public void should_return_invalid_option_message() {
        BibliotecaApp.displayInvalidOptionMessage();
        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void should_return_true_for_valid_option() {
        BibliotecaApp.addValidOptions(1);
        assertTrue(BibliotecaApp.isValidOption("1"));
    }

    @Test
    public void should_return_false_for_invalid_option() {
        BibliotecaApp.addValidOptions(1);
        assertFalse(BibliotecaApp.isValidOption("3"));
    }

    @Test
    public void should_return_book_author_Jane_Austen() {
        Book prideAndPrejudice = new Book("Pride and Prejudice", "Jane Austen", "1995");
    }
}
