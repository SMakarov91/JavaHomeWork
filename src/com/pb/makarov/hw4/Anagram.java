package com.pb.makarov.hw4;

import java.util.Scanner;
import java.util.Arrays;

public class Anagram {

    static String scanStr() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = scan.nextLine().toLowerCase().replaceAll("[^а-яa-zіїє]", "");

        return str;
    }

    static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    static boolean compareStr(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    public static void main(String[] args) {
        String str = scanStr();
        String str2 = scanStr();

        boolean rez = compareStr(str, str2);
        System.out.println(rez ? "Строки анаграмма" : "Строки не анаграмма");
    }
}
