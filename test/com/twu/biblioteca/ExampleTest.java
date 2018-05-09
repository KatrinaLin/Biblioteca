package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void should_display_welcome_message() {
        assertEquals("Welcome to the Biblioteca!", BibliotecaApp.displayWelcomeMessage());
    }
}
