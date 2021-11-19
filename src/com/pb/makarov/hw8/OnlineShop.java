package com.pb.makarov.hw8;

import java.util.Scanner;

public class OnlineShop {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Придумайте логин: от 5 до 20 символов, только латинские буквы и цифры");
        String login = scan.nextLine();

        System.out.println("Придумайте пароль: длинна более 5, только латинские буквы, цифры и знак подчеркивания");
        String password = scan.nextLine();

        System.out.println("Повторите пароль: ");
        String confirmPassword = scan.nextLine();

        Auth auth = new Auth();
        try {
            auth.signUp(login, password, confirmPassword);
            try {
                System.out.println("Введите логин для входа");
                login = scan.nextLine();
                System.out.println("Введите пароль для входа");
                password = scan.nextLine();

                auth.signIn(login, password);

            } catch (WrongLoginException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Регистрация не пройдена");
        }
    }
}
