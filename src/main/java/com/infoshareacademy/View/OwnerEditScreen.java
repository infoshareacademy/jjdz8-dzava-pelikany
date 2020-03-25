package com.infoshareacademy.View;

import com.infoshareacademy.Utilities.OwnerEdit;

import java.io.IOException;
import java.util.Scanner;

import static com.infoshareacademy.View.Screen.clearScreen;

public class OwnerEditScreen {

    public void ownerEditMenu() throws IOException, InterruptedException {
        clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("                Profil Właściciela.");
        System.out.println("-----------------------------------------------------");
        System.out.println("Wybierz, co chcesz edytować: ");
        System.out.println("1. Login");
        System.out.println("2. Imię ");
        System.out.println("3. Nazwisko");
        System.out.println("4. Email");
        System.out.println("\n\n0. Powrót do menu");

        byte dialedNumber = scanner.nextByte();
        OwnerEdit ownerEdit = new OwnerEdit();
        switch (dialedNumber) {
            case (1):
                ownerEdit.editOwnerLogin();
                break;
            case (2):
                ownerEdit.editName();
                break;
            case (3):
                ownerEdit.editSurname();
                break;
            case (4):
                ownerEdit.editEmail();
                break;
            case (0):
                Menu.mainMenu();
                break;
        }


    }
}
