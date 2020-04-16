package com.infoshareacademy.view;

import com.infoshareacademy.utilities.OwnerEdit;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class OwnerEditScreen implements Screen {

    public void ownerEditMenu() throws IOException, InterruptedException {
        Screen.clearScreen();
        Scanner scanner = new Scanner(in);
        out.println(LINE);
        out.println("                Profil Właściciela.");
        out.println(LINE);
        Screen.editData();

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
            default:
                out.println(WRONG_ANSWER);
                ownerEditMenu();
        }


    }
}
