package com.infoshareacademy.view;

import com.infoshareacademy.utilities.OwnerAccountCreator;
import com.infoshareacademy.utilities.TenantAccountCreator;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class RegistrationScreen implements Screen {

    OwnerAccountCreator ownerAccountCreator = new OwnerAccountCreator();
    TenantAccountCreator tenantAccountCreator = new TenantAccountCreator();

    public void signUp() throws IOException, InterruptedException {

        Screen.clearScreen();
        Scanner scanner = new Scanner(in);
        out.println("-----------------------------------------------------");
        out.println("                    Rejestracja: ");
        out.println("-----------------------------------------------------");
        out.println("Wybierz typ użytkownika: ");
        out.println("1.Właściciel / 2.Lokator");
        byte dialedNumber1 = scanner.nextByte();
        switch (dialedNumber1){
            case 1:
                ownerAccountCreator.makeOwnerAccount();
                break;
            case 2:
                tenantAccountCreator.makeTenantAccount();
                break;

            default:
                out.println(WRONG_ANSWER);
                signUp();
        }

                Menu.mainMenu();
    }
}
