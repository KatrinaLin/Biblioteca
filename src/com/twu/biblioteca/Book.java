package com.twu.biblioteca;

public class Book {

    private final String name;
    private final String author;
    private final String yearPublished;

    public Book(String name, String author, String yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearPublished() {
        return yearPublished;
    }
}
