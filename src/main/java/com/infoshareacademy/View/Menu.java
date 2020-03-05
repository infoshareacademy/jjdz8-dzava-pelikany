package com.infoshareacademy.View;

import java.io.IOException;
import java.util.Scanner;

public class Menu extends Screen{

    public static void mainMenu() throws IOException {
        clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("       Witaj w aplikacji prod. DzavaPelikany!");
        System.out.println("-----------------------------------------------------");
        System.out.println("1. Rejestracja.");
        System.out.println("2. Logowanie.");
        System.out.println("3. Wyświetl ekran Właściciela. ");
        System.out.println("4. Wyświetl ekran Lokatora. ");
        System.out.println("0. Wyjście.");
        System.out.println(" ");
        System.out.println("Wprowadź swój wybór:  ");

        RegistrationScreen registrationScreen = new RegistrationScreen();
        LoginScreen loginScreen = new LoginScreen();
        OwnerScreen ownerScreen = new OwnerScreen();
        TenantScreen tenantScreen = new TenantScreen();

        byte dialedNumber = scanner.nextByte();
        switch (dialedNumber) {
            case 1:
                registrationScreen.signUp();
                break;
            case 2:
                loginScreen.signIn();
                break;
            case 3:
                //Tu dla sprawdzenia dodalem opcje wyswietlenia ekrany wlasciciela
                ownerScreen.ownerMenu();
            case 4:
                //Tu dla sprawdzenia dodalem opcje wyswietlenia ekrany lokatora
                tenantScreen.tenantMenu();

            case 0:
                System.exit(0);
        }
    }
}
