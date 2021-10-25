package com.pb.makarov.hw4;

import java.util.Scanner;

public class CapitalLetter {

    static String scanStr() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = scan.nextLine();

        return str;
    }

    public static String toCamelCase(String givStr) {
        String[] arr = givStr.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(toCamelCase(scanStr()));
    }
}
