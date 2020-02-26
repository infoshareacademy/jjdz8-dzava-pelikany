package com.infoshareacademy.menu;

import java.io.IOException;
import java.util.Scanner;

public class TenantScreen {

    public void tenantMenu() throws IOException {
        clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("Witaj w aplikacji prod. DzavaPelikany!");
        System.out.println("-----------------------------------------------------");
        System.out.println("1. Dodaj mieszkanie.");
        System.out.println("2. Edytuj dane mieszkania.");
        System.out.println("3. Rejestruj wynajęcie mieszkania.");
        System.out.println();
        System.out.println();
        System.out.println("4. Edytuj swoje dane.");
        System.out.println("0. Wyloguj.");
        byte dialedNumber = scanner.nextByte();
        switch (dialedNumber) {
            case (1):
                //do napisania
                break;
            case (2):
                //do napisania
                break;
            case (3):
                //do napisania
                break;
            case (4):
                //do napisania
                break;
            case (0):
                Menu.mainMenu();
                break;
        }
    }

    public static void clearScreen() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
