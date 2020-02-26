package com.infoshareacademy.menu;

import java.io.IOException;
import java.util.Scanner;

public class RegistrationScreen {

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String login;
    private String password;

    public void signUp() throws IOException {
        clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("Rejestracja: ");
        System.out.println("-----------------------------------------------------");
        System.out.println("Wprowadź dane : \n");
        System.out.println("Imię : ");
        name = scanner.nextLine();
        System.out.println("Nazwisko : ");
        surname = scanner.nextLine();
        System.out.println("Email : ");
        email = scanner.nextLine();
        System.out.println("Numer telefonu : ");
        phoneNumber = scanner.nextLine();
        System.out.println("Login : ");
        login = scanner.nextLine();
        System.out.println("Password : ");
        password = scanner.nextLine();
        clearScreen();
        System.out.println("-----------------------------------------------------");
        System.out.println("Dziękujemy ! Teraz wybierz jedną z opcji :");
        System.out.println("1. Zapisz dane. / 0. Cofnij.");
        byte dialedNumber = scanner.nextByte();
        switch (dialedNumber) {
            case 1:
                System.out.println("Dane zapisane!");
//                Tu trzeba dodać funcję zapisywania danych do JSON
                Menu.mainMenu();
                break;
            case 0:
                Menu.mainMenu();
        }
    }

    public static void clearScreen() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
