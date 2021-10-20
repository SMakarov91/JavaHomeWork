package com.pb.makarov.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] array = new int[10];
        int sum = 0;
        int count = 0;
        int buf;

        System.out.println("Введите 10 целых чисел: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Число № " + (i + 1));
            array[i] = scan.nextInt();
        }

        System.out.println("Массив чисел: ");
        for (int anArray : array) {
            System.out.print(anArray + " ");
            sum += anArray;
            if (anArray > 0) {
                count++;
            }
        }
        System.out.println("\n");
        System.out.println("Сумма всех элементов массива: " + sum);
        System.out.println("Колличество положительных элементов: " + count);

        for (int i = array.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (array[j] > array[j + 1]) {
                    buf = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buf;
                }

        System.out.println("Массив чисел после сортировки: ");
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }

    }
}
