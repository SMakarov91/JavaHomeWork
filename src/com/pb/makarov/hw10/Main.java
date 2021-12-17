package com.pb.makarov.hw10;

public class Main {
    public static void main(String[] args) {

        NumBox<Integer> objInt = new NumBox<Integer>(8);

        try {
            objInt.add(12);
            objInt.add(35);
            objInt.add(20);
            objInt.add(25);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Число по индексу [2] - " + objInt.get(2));
        System.out.println("Текущее количество элементов " + objInt.length());
        System.out.println("Cреднее арифметическое элементов массива " + objInt.average());
        System.out.println("Сумма всех элементов массива " + objInt.sum());
        System.out.println("Максимальный элемент массива " + objInt.max());

    }
}
