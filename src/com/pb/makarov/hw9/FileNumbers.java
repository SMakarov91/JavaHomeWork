package com.pb.makarov.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileNumbers {

    static void createNumbersFile() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 99 + 1);
        }

        Path path = Paths.get("numbers.txt");
        // write to file
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < array.length; i++) {
                if (i % 10 == 0 && i != 0) {
                    writer.newLine();
                    writer.write(array[i] + " ");
                } else
                    writer.write(array[i] + " ");
            }

        } catch (Exception ex) {
            System.out.println("Error with file write: " + ex);
        }
        System.out.println("Write to file \"" + path.toAbsolutePath() + "\" done!");
    }


    static void createOddNumbersFile() {
        String lineNum = "";

        // read from file
        Path path = Paths.get("numbers.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] arrayNum = line.split(" ");

                for (int i = 0; i < arrayNum.length; i++) {
                    if (Integer.parseInt(arrayNum[i]) % 2 == 0) {
                        arrayNum[i] = "0";
                    }
                }

                for (int i = 0; i < arrayNum.length; i++) {
                    lineNum += arrayNum[i] + " ";
                }
            }

        } catch (Exception ex) {
            System.out.println("Error with file read: " + ex);
        }
        System.out.println("Read text from file \"" + path.toAbsolutePath() + "\" done!");


        // write to file
        path = Paths.get("odd-numbers.txt");
        String[] arrayNum = lineNum.split(" ");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < arrayNum.length; i++) {
                if (i % 10 == 0 && i != 0) {
                    writer.newLine();
                    writer.write(arrayNum[i] + " ");
                } else
                    writer.write(arrayNum[i] + " ");
            }

        } catch (Exception ex) {
            System.out.println("Error with file write: " + ex);
        }
        System.out.println("Write to file \"" + path.toAbsolutePath() + "\" done!");
    }


    public static void main(String[] args) {
        createNumbersFile();
        createOddNumbersFile();
    }
}
