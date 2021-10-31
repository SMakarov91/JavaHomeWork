package com.pb.makarov.hw5;


public class Reader {

    private String fio;
    private int cardNumber;
    private String faculty;
    private String birthday;
    private String phone;

    private int bookTakeCnt;
    private int bookReturnCnt;

    public Reader(String fio, int cardNumber, String faculty, String birthday, String phone) {
        this.fio = fio;
        this.cardNumber = cardNumber;
        this.faculty = faculty;
        this.birthday = birthday;
        this.phone = phone;
    }

    public int getBookTakeCnt() {
        return bookTakeCnt;
    }

    public int getBookReturnCnt() {
        return bookReturnCnt;
    }

    public String getInfoReader() {
        return "[ФИО: " + fio + ", факультет: " + faculty + ", дата рождения: " + birthday + ", телефон: " + phone + "]";
    }

    public void takeBook(int bookCount) {
        System.out.println(fio + " взял " + bookCount + " книги");
    }

    public void takeBook(String... nameBook) {
        System.out.print(fio + " взял книги: ");
        for (String book : nameBook) {
            System.out.print(book + ", ");
            bookTakeCnt++;
        }
        System.out.println("");
    }

    public void takeBook(Book... books) {
        System.out.print(fio + " взял книги: ");
        for (Book book : books) {
            System.out.print(book.getNameBook() + " (" + book.getAuthor() + " " + book.getYearPublishing() + " г.), ");
        }
        System.out.println("");
    }


    public void returnBook(int bookCount) {
        System.out.println(fio + " вернул " + bookCount + " книги");
    }

    public void returnBook(String... nameBook) {
        System.out.print(fio + " вернул книги: ");
        for (String book : nameBook) {
            System.out.print(book + ", ");
            bookReturnCnt++;
        }
        System.out.println("");
    }

    public void returnBook(Book... books) {
        System.out.print(fio + " вернул книги: ");
        for (Book book : books) {
            System.out.print(book.getNameBook() + " (" + book.getAuthor() + " " + book.getYearPublishing() + " г.), ");
        }
        System.out.println("");
    }

}
