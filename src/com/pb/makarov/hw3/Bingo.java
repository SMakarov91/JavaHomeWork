package com.pb.makarov.hw3;

import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int hidNum = (int) (Math.random() * 101);
        int entNum;
        int counter = 0;

        do {
            counter++;
            System.out.println("Введите загаданное число от 0 до 100 (для выхода используйте отрицательные числа): ");
            entNum = scan.nextInt();

            if (entNum < 0) break;

            if (hidNum > entNum) {
                System.out.println("Вы не угадали, загаданное число больше " + entNum);
            } else if (hidNum < entNum) {
                System.out.println("Вы не угадали, загаданное число меньше " + entNum);
            }

        }
        while (hidNum != entNum);

        if (hidNum == entNum) {
            System.out.println("Вы угадали число: " + hidNum + ", количество попыток - " + counter);
        } else {
            System.out.println("Вы вышли, количество попыток - " + counter);
        }

    }
}
