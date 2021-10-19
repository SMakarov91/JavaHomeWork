package com.pb.makarov.hw3;

import java.util.Scanner;

public class Bingo2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int hidNum = (int) (Math.random() * 101);
        int entNum=0;
        int counter;

        for (counter = 0; hidNum != entNum; counter++) {

            System.out.println("Введите загаданное число от 0 до 100 (для выхода используйте отрицательные числа): ");
            entNum = scan.nextInt();

            if (entNum < 0) break;

            if (hidNum > entNum) {
                System.out.println("Вы не угадали, загаданное число больше " + entNum);
            } else if (hidNum < entNum) {
                System.out.println("Вы не угадали, загаданное число меньше " + entNum);
            }

        }

        if (hidNum == entNum) {
            System.out.println("Вы угадали число: " + hidNum + ", количество попыток - " + counter);
        } else {
            System.out.println("Вы вышли, количество попыток - " + counter);
        }

    }
}
