package com.infoshareacademy.view;

import com.infoshareacademy.utilities.RoomSearch;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class TenantScreen implements Screen {

    public void tenantMenu() throws IOException, InterruptedException {
        Screen.clearScreen();
        Scanner scanner = new Scanner(in);
        out.println("-----------------------------------------------------");
        out.println("                  Profil Lokatora.");
        out.println("-----------------------------------------------------");
        out.println("1. Szukaj pokoju.");
        out.println("2. Status wynajętego pokoju.");
        out.println();
        out.println();
        out.println("3. Edytuj swoje dane.");
        out.println("0. Wyloguj.");
        byte dialedNumber = scanner.nextByte();
        switch (dialedNumber) {
            case (1):
                RoomSearch roomSearch = new RoomSearch();
                roomSearch.setCriteria();
                break;
            case (2):
                //TODO
                break;
            case (3):
                TenantEditScreen tenantEditScreen = new TenantEditScreen();
                tenantEditScreen.tenantEditMenu();
                break;
            case (0):
                Menu.mainMenu();
                break;
            default:
               out.println(WRONG_ANSWER);
               tenantMenu();
        }
    }

}
