package com.infoshareacademy.view;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class LoginScreen implements Screen{

    OwnerScreen ownerScreen = new OwnerScreen();
    TenantScreen tenantScreen = new TenantScreen();
    Scanner scanner = new Scanner(in);

    public void printOptions(){
        out.println(LINE);
        out.println("                    Logowanie: ");
        out.println(LINE);
        out.println("Wybierz typ użytkownika: ");
        out.println("1.Właściciel / 2.Lokator");
        out.println(LINE);
        out.println("3. Powrót do menu głównego");

    }

    public void signIn() throws IOException, InterruptedException {
        Screen.clearScreen();
        printOptions();
        byte dialedNumber = scanner.nextByte();
        switch (dialedNumber) {
            case 1:
                ownerScreen.ownerMenu();
            break;
            case 2:
                tenantScreen.tenantMenu();
            break;
            case 3:
                Menu.mainMenu();
            break;
            default:
                out.println(WRONG_ANSWER);
                signIn();
        }
    }
}
