package com.infoshareacademy.View;

import com.infoshareacademy.Utilities.OwnerEdit;
import com.infoshareacademy.Utilities.TenantEdit;

import java.io.IOException;
import java.util.Scanner;

import static com.infoshareacademy.View.Screen.clearScreen;

public class TenantEditScreen {

    public void tenantEditMenu() throws IOException {
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
        }


    }


}
