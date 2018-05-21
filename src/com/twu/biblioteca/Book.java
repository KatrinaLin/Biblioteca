package com.twu.biblioteca;

public class Book {

    private String name;
    private String author;
    private String yearPublished;
    private boolean isAvailable = true;

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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Bookname: " + name + " | Author: " + author + " | Year Published: " + yearPublished;
    }
}
