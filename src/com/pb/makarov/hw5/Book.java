package com.pb.makarov.hw5;

public class Book {

    private String nameBook;
    private String author;
    private int yearPublishing;

    public Book(String nameBook, String author, int yearPublishing) {
        this.nameBook = nameBook;
        this.author = author;
        this.yearPublishing = yearPublishing;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublishing() {
        return yearPublishing;
    }

    public String getInfoBook() {
        return "[книга: " + nameBook + ", автор: " + author + ", год издания: " + yearPublishing + "]";
    }
}
