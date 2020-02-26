package com.infoshareacademy.menu;

import java.io.IOException;
import java.util.Scanner;

public class LoginScreen {

    private String login;
    private String password;

    public void signIn() throws IOException {
        clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("Logowanie: ");
        System.out.println("-----------------------------------------------------");
        System.out.println("Wprowadź dane : \n");
        System.out.println("Login : ");
        login = scanner.nextLine();
        System.out.println("Password : ");
        password = scanner.nextLine();
        clearScreen();
        System.out.println("-----------------------------------------------------");
        System.out.println("Dziękujemy ! Teraz wybierz jedną z opcji :");
        System.out.println("1. Zaloguj. / 0. Cofnij.");
        byte dialedNumber = scanner.nextByte();
        switch (dialedNumber) {
            case 1:
//Tu trzeba napisac funkcje ktora po zalogowaniu wyswietla menu dla danego uzytkownika
            case 0:
                Menu.mainMenu();
        }
    }

    public static void clearScreen() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
