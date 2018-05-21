package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static List<Integer> validOptions = new ArrayList<>();

    private static HashMap<String, Book> bookMap;

    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepository();

        bookMap = bookRepository.getBookMap();

        addValidOptions(1);
        startApp();
    }

    private static void startApp() {
        displayWelcomeMessage();
        displayMainMenu();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals("Quit")) {
                break;
            }

            if (!isValidOption(input)) {
                displayInvalidOptionMessage();
                displayMainMenu();
            } else {
                displayAvailableBookList();
            }

        }

        scanner.close();
    }


    public static void displayWelcomeMessage() {
        System.out.println("Welcome to the Biblioteca!");
    }

    public static void displayMainMenu() {
        System.out.println("Main menu\n1. List Books");
        System.out.println("Type \"Quit\" to quit the app.");
    }

    public static void displayInvalidOptionMessage() {
        System.out.println("Select a valid option!");
    }

    public static void addValidOptions(Integer i) {
        validOptions.add(i);
    }

    public static boolean isValidOption(String input) {
        return validOptions.contains(Integer.valueOf(input));
    }

    public static void displayAvailableBookList() {
        bookMap.values()
                .stream()
                .filter(x -> x.isAvailable())
                .forEach(x -> System.out.println(x));
    }


}
