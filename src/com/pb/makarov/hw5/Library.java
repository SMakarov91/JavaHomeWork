package com.pb.makarov.hw5;

public class Library {
    public static void main(String[] args) {

        Book book1 = new Book("Зеленая миля", "Стивен Кинг", 2020);
        Book book2 = new Book("Буря мечей", "Джордж Мартин", 2008);
        Book book3 = new Book("Тысяча сияющих солнц", "Халед Хоссейни", 2015);

        Book[] books = new Book[]{book1, book2, book3};

        Reader reader1 = new Reader("Семенов А.С.", 1001, "Прикладная физика", "05/04/1985", "+380660000001");
        Reader reader2 = new Reader("Иванов И.И", 1002, "Математический", "20/08/1990", "+380670000002");
        Reader reader3 = new Reader("Сидоров О.Е.", 1003, "Экономический", "17/11/1994", "+380680000003");

        Reader[] readers = new Reader[]{reader1, reader2, reader3};

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getInfoBook());
        }

        for (int i = 0; i < readers.length; i++) {
            System.out.println(readers[i].getInfoReader());
        }

        reader1.takeBook(book1.getNameBook(), book2.getNameBook(), book3.getNameBook());
        reader1.takeBook(reader1.getBookTakeCnt());
        reader1.takeBook(book1, book2, book3);

        reader1.returnBook(book1.getNameBook(), book2.getNameBook(), book3.getNameBook());
        reader1.returnBook(reader1.getBookReturnCnt());
        reader1.returnBook(book1, book2, book3);
    }
}
