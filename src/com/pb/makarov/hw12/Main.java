package com.pb.makarov.hw12;

import com.pb.makarov.hw11.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static PhoneBook addElement(Scanner scan) {
        String str = scan.nextLine();
        System.out.println("Введите ФИО: ");
        String fio = scan.nextLine();

        System.out.println("Введите дату рождения в формате dd/MM/yyyy: ");
        LocalDate dateOfBirth = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Введите телефон: ");
        String phone = scan.nextLine();

        System.out.println("Введите адрес: ");
        String address = scan.nextLine();

        PhoneBook phoneBook = new PhoneBook(fio, dateOfBirth, phone, address);
        return phoneBook;
    }

    private static String scanner(Scanner scan) {
        String str = scan.nextLine();
        return scan.nextLine();
    }

    private static void edit(List<PhoneBook> phoneBookList, Scanner scan) {
        String str = scan.nextLine();
        System.out.println("Введите ФИО для поиска: ");
        String fio = scan.nextLine();
        int index = -1;

        for (PhoneBook i : phoneBookList) {
            if (i.getFio().equals(fio)) {
                index = phoneBookList.indexOf(i);
            }
        }

        try {
            PhoneBook phoneBook = phoneBookList.get(index);

            System.out.println();
            System.out.println("1. Редактировать ФИО");
            System.out.println("2. Редактировать дату рождения");
            System.out.println("3. Редактировать телефон");
            System.out.println("4. Редактировать адрес");
            System.out.println("0. Главное меню");

            String option = scan.next();

            switch (option) {
                case "1":
                    System.out.println("Введите новое ФИО:");
                    phoneBook.setFio(scanner(scan));
                    break;
                case "2":
                    System.out.println("Введите новую дату в формате dd/MM/yyyy :");
                    phoneBook.setDateOfBirth(LocalDate.parse(scanner(scan), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    break;
                case "3":
                    System.out.println("Введите номер телефона:");
                    phoneBook.setPhone(scanner(scan));
                    break;
                case "4":
                    System.out.println("Введите новый адрес:");
                    phoneBook.setAddress(scanner(scan));
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Wrong menu number!");
            }
            phoneBookList.set(index, phoneBook);
            if (!option.equals("0")) {
                System.out.println("Данные отредактированы");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ФИО: " + fio + " не найдено.");
        }

    }


    public static void main(String[] args) throws Exception {

        String phoneBookJson;

        ObjectMapper mapper = new ObjectMapper();
        // pretty printing (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // для работы с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module);


        List<PhoneBook> phoneBookList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("1. Вывести справочник на экран");
            System.out.println("2. Добавить запись");
            System.out.println("3. Удалить запись");
            System.out.println("4. Поиск элементов");
            System.out.println("5. Сортировка по ФИО");
            System.out.println("6. Сортировка по дате рождения");
            System.out.println("7. Отредактировать элемент");
            System.out.println("8. Записать в файл");
            System.out.println("9. Загрузка из файла всех данных");
            System.out.println("0. Exit");

            String option = scan.next();

            switch (option) {
                case "1":
                    phoneBookJson = mapper.writeValueAsString(phoneBookList);
                    System.out.println(phoneBookJson);
                    break;

                case "2":
                    PhoneBook phoneBook = addElement(scan);
                    phoneBookList.add(phoneBook);
                    System.out.println("Элемент добавлен.");
                    break;

                case "3":
                    System.out.println("Введите ФИО для удаления: ");
                    String removeFio = scanner(scan);

                    List<PhoneBook> removeList = phoneBookList.stream()
                            .filter(p -> p.getFio().equals(removeFio))
                            .collect(Collectors.toList());

                    phoneBookList.removeAll(removeList);
                    break;

                case "4":
                    System.out.println("Введите ФИО для поиска: ");
                    String searchFio = scanner(scan);

                    phoneBookList.stream()
                            .filter(p -> p.getFio().equals(searchFio))
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    break;

                case "5":
                    phoneBookList.stream()
                            .sorted(Comparator.comparing(PhoneBook::getFio))
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    break;

                case "6":
                    phoneBookList.stream()
                            .sorted(Comparator.comparing(PhoneBook::getDateOfBirth))
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    break;

                case "7":
                    edit(phoneBookList, scan);
                    break;

                case "8":
                    FileWriter file = new FileWriter("phoneBook.json");
                    phoneBookJson = mapper.writeValueAsString(phoneBookList);
                    file.append(phoneBookJson);
                    file.flush();
                    file.close();

                    System.out.println("Запись в файл завершена.");
                    break;

                case "9":
                    phoneBookList = new ArrayList<>(Arrays.asList(mapper.readValue(Paths.get("phoneBook.json").toFile(), PhoneBook[].class)));
                    phoneBookJson = mapper.writeValueAsString(phoneBookList);
                    System.out.println(phoneBookJson);
                    break;

                case "0":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Wrong menu number!");
            }
        }

    }
}