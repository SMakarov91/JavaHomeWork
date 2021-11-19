package com.pb.makarov.hw8;

public class Auth {

    private String login;
    private String password;

    //Регистрация
    public void signUp(String login, String password, String confirmPassword) throws Exception {
        if (!login.matches("^[a-zA-Z0-9]{5,20}$")) {
            throw new WrongLoginException("Логин не соответствует требованиям: от 5 до 20 символов, только латинские буквы и цифры");
        } else if (password.length() < 5) {
            throw new WrongPasswordException("Пароль не соответствует требованиям: Длина пароля менее 5 символов");
        } else if (!password.matches("^[\\w]{5,}$")) {
            throw new WrongPasswordException("Пароль не соответствует требованиям: только латинские буквы, цифры и знак подчеркивания");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        } else {
            this.login = login;
            this.password = password;
            System.out.println("Регистрация успешно завершена.");
            System.out.println();
        }
    }

    public void signIn(String login, String password) throws WrongLoginException {
        if (this.login.equals(login) && this.password.equals(password)) {
            System.out.println("Вход выполнен");
        } else {
            throw new WrongLoginException("Вход не выполнен: Логин или пароль введены не верно");
        }
    }
}
