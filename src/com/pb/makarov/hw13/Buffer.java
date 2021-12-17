package com.pb.makarov.hw13;

import java.util.LinkedList;

public class Buffer {

    private int num = 0;
    LinkedList<Integer> numList = new LinkedList<Integer>();

    public synchronized void get() {
        while (numList.size() < 1) {
            try {
                System.out.println("Буфер пуст. Ожидаем вызов производителя.");
                System.out.println();
                wait();
            } catch (InterruptedException e) {
            }
        }

        num = numList.removeFirst();

        System.out.println("Потребитель забрал число: " + num);
        System.out.println("Количество чисел в буфере: " + numList.size());
        System.out.println(numList);
        System.out.println();
        notify();
    }

    public synchronized void put() {
        while (numList.size() == 5) {
            try {
                System.out.println("Буфер заполнен. Ожидаем вызов потребителя.");
                System.out.println();
                wait();
            } catch (InterruptedException e) {
            }
        }

        num = (int) (Math.random() * 101);
        numList.add(num);

        System.out.println("Производитель добавил число: " + num);
        System.out.println("Количество чисел в буфере: " + numList.size());
        System.out.println(numList);
        System.out.println();
        notify();
    }
}
