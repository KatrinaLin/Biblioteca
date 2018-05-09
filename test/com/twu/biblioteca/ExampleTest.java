package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void should_display_welcome_message() {
        assertEquals("Welcome to the Biblioteca!", BibliotecaApp.displayWelcomeMessage());
    }

    @Test
    public void should_display_main_menu() {
         assertEquals("Main menu\n1. List Books", BibliotecaApp.displayMainMenu());
    }

    @Test
    public void should_return_invalid_option_message() {
        assertEquals("Select a valid option!", BibliotecaApp.invalidOptionMessage());
    }
}
