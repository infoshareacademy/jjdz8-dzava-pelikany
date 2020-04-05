package com.infoshareacademy.view;


import com.infoshareacademy.utilities.RoomCreator;
import com.infoshareacademy.utilities.RoomRegistration;

import java.io.IOException;
import java.util.Scanner;

import static com.infoshareacademy.view.Screen.clearScreen;
import static java.lang.System.*;

public class OwnerScreen implements Screen{

    public void ownerMenu() throws IOException, InterruptedException {
        clearScreen();
        Scanner scanner = new Scanner(in);
        out.println("-----------------------------------------------------");
        out.println("                Profil Właściciela.");
        out.println("-----------------------------------------------------");
        out.println("1. Dodaj mieszkanie.");
        out.println("2. Edytuj dane mieszkania.");
        out.println("3. Rejestruj wynajęcie mieszkania.");
        out.println();
        out.println();
        out.println("4. Edytuj swoje dane.");
        out.println("0. Wyloguj.");

        byte dialedNumber = scanner.nextByte();
        switch (dialedNumber) {
            case (1):
                RoomCreator roomCreator = new RoomCreator();
                roomCreator.createRoom();
                break;
            case (2):
                RoomEditScreen roomEditScreen = new RoomEditScreen();
                roomEditScreen.roomEditMenu();
                break;
            case (3):
                RoomRegistration roomRegistration = new RoomRegistration();
                roomRegistration.registerRoom();
                break;
            case (4):
                OwnerEditScreen ownerEditScreen = new OwnerEditScreen();
                ownerEditScreen.ownerEditMenu();
                break;
            case (0):
                Menu.mainMenu();
                break;
            default:
                out.println(WRONG_ANSWER);
                ownerMenu();
        }
    }
}
