package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        displayWelcomeMessage();
        displayMainMenu();

        Scanner scanner = new Scanner(System.in);
    }


    public static String displayWelcomeMessage() {
        return "Welcome to the Biblioteca!";
    }

    public static String displayMainMenu() {
        return "Main menu\n1. List Books";
    }
}
