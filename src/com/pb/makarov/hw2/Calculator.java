package com.pb.makarov.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int rez = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        int operand1 = scan.nextInt();

        System.out.println("Введите второе число: ");
        int operand2 = scan.nextInt();

        System.out.println("Выберите операцию '+' - сложение, '-' - вычитание, '*' - умножение, '/' - деление: ");
        String sign = scan.next();

        char op = sign.charAt(0);

        if (operand2 == 0 & op == '/') {
            System.out.println("На 0 делить нельзя");
            return;
        } else {
            switch (op) {
                case '+':
                    rez = operand1 + operand2;
                    break;
                case '-':
                    rez = operand1 - operand2;
                    break;
                case '*':
                    rez = operand1 * operand2;
                    break;
                case '/':
                    rez = operand1 / operand2;
                    break;
                default:
                    System.out.println("Неверная операция");
                    return;
            }
        }
        System.out.println("Результат: " + rez);
    }
}
