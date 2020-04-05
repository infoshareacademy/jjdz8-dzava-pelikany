package com.infoshareacademy.view;

import com.infoshareacademy.utilities.TenantEdit;

import java.io.IOException;
import java.util.Scanner;

import static com.infoshareacademy.view.Screen.clearScreen;
import static java.lang.System.*;

public class TenantEditScreen implements Screen {

    public void tenantEditMenu() throws IOException , InterruptedException{
        clearScreen();
        Scanner scanner = new Scanner(in);
        out.println(LINE);
        out.println("                Profil Wynajmującego.");
        out.println(LINE);
       Screen.editData();

        byte dialedNumber = scanner.nextByte();
        TenantEdit tenantEdit = new TenantEdit();
        switch (dialedNumber) {
            case (1):
                tenantEdit.editTenantLogin();
                break;
            case (2):
                tenantEdit.editName();
                break;
            case (3):
                tenantEdit.editSurname();
                break;
            case (4):
                tenantEdit.editEmail();
                break;
            case (0):
                Menu.mainMenu();
                break;
            default:
                out.println(WRONG_ANSWER);
                tenantEditMenu();
        }


    }


}
