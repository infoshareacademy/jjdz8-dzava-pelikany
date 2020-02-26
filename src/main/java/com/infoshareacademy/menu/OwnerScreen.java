package com.infoshareacademy.menu;

import java.io.IOException;
import java.util.Scanner;

public class OwnerScreen {
    public void ownerMenu() throws IOException {
        clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("Witaj w aplikacji prod. DzavaPelikany!");
        System.out.println("-----------------------------------------------------");
        System.out.println("1. Szukaj pokoju.");
        System.out.println("2. Status wynajętego pokoju.");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("3. Edytuj swoje dane.");
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
