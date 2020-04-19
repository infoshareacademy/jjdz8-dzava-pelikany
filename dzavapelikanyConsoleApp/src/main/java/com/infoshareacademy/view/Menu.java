package com.infoshareacademy.view;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class Menu implements Screen{

    public static void mainMenu() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(in);
        out.println(LINE);
        out.println("       Witaj w aplikacji prod. DzavaPelikany!");
        out.println(LINE);
        out.println("1. Rejestracja.");
        out.println("2. Logowanie.");
        out.println("3. Wyjście.");
        out.println(" ");
        out.println("Wprowadź swój wybór:  ");

        RegistrationScreen registrationScreen = new RegistrationScreen();
        LoginScreen loginScreen = new LoginScreen();

        byte dialedNumber = scanner.nextByte();
        switch (dialedNumber) {
            case 1:
                registrationScreen.signUp();
                break;
            case 2:
                loginScreen.signIn();
                break;
            case 3:
                exit(3);
                break;
            default:
                out.println(WRONG_ANSWER);
               Menu.mainMenu();
        }
    }
}
