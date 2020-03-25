package com.infoshareacademy.View;

import com.infoshareacademy.Utilities.SaveAndLoad;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class RegistrationScreen extends Screen {


    public void signUp() throws IOException, InterruptedException {

        SaveAndLoad saveAndLoad = new SaveAndLoad();
        clearScreen();
        Scanner scanner = new Scanner(in);
        out.println("-----------------------------------------------------");
        out.println("                    Rejestracja: ");
        out.println("-----------------------------------------------------");
        out.println("Wybierz typ użytkownika: ");
        out.println("1.Właściciel / 0.Lokator");
        byte dialedNumber1 = scanner.nextByte();
        switch (dialedNumber1) {
            case 1:
                saveAndLoad.makeOwnerAccount();
                break;
            case 0:
                saveAndLoad.makeTenantAccount();
        }
        out.println("\n-----------------------------------------------------");
        out.println("Dziękujemy! Teraz wybierz jedną z opcji :");
        out.println("1. Cofnij do menu głownego. / 0. Wyjdź z aplikacji.");
        byte dialedNumber = scanner.nextByte();
        switch (dialedNumber) {
            case 1:
                Menu.mainMenu();
                break;
            case 0:
                System.exit(0);
        }
    }
}
