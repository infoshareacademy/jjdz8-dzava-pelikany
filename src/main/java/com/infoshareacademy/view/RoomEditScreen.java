package com.infoshareacademy.view;

import com.infoshareacademy.utilities.RoomEdit;

import java.io.IOException;
import java.util.Scanner;

import static com.infoshareacademy.view.Screen.clearScreen;

public class RoomEditScreen {

    public void roomEditMenu() throws IOException, InterruptedException {
        clearScreen();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------");
        System.out.println("                Edycja danych pokoju.");
        System.out.println("-----------------------------------------------------");
        System.out.println("Wybierz, co chcesz edytować: ");
        System.out.println("1. Ulicę i numer domu.");
        System.out.println("2. Miasto. ");
        System.out.println("3. Powierzchnię pokoju. ");
        System.out.println("4. Cenę wynajmu. ");
        System.out.println("\n\n0. Powrót do menu");

        byte dialedNumber = scanner.nextByte();

        RoomEdit roomEdit = new RoomEdit();
        switch (dialedNumber) {
            case (1):
                roomEdit.editRoomStreetAndNumber();
                break;
            case (2):
                roomEdit.editRoomCity();
                break;
            case (3):
                roomEdit.editRoomArea();
                break;
            case (4):
                roomEdit.editRoomPrice();
                break;
            case (0):
                Menu.mainMenu();
                break;
        }


    }
}
