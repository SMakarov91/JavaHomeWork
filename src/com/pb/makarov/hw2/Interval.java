package com.pb.makarov.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите число от 0 до 100: ");
        int num = scan.nextInt();

        if (num >= 0 & num <= 14) {
            System.out.println(num + " попадает в интервал от 0 до 14");
        } else if (num >= 15 & num <= 35) {
            System.out.println(num + " попадает в интервал от 15 до 35");
        } else if (num >= 36 & num <= 50) {
            System.out.println(num + " попадает в интервал от 36 до 50");
        } else if (num >= 51 & num <= 100) {
            System.out.println(num + " попадает в интервал от 51 до 100");
        } else {
            System.out.println(num + " не попало ни в один интервал");
        }
    }
}
