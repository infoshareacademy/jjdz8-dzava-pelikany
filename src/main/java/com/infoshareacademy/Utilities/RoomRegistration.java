package com.infoshareacademy.Utilities;
import com.infoshareacademy.Entity.Room;
import com.infoshareacademy.Entity.Rooms;
import com.infoshareacademy.Entity.Tenant;
import com.infoshareacademy.Entity.Tenants;
import com.infoshareacademy.View.OwnerScreen;
import com.infoshareacademy.View.Screen;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;


public class RoomRegistration extends Screen {

    public void registerRoom() throws IOException, InterruptedException {

        Long userTenantNrInput = null;
        Long userRoomNrInput = null;
        String userRoomTermInput = null;
        UUID roomUUID = null;
        OwnerScreen ownerScreen = new OwnerScreen();

        clearScreen();
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        System.out.println("");
        System.out.println("Lista Pokoi:");
        System.out.println("");
        for (int i = 0; i < rooms.getRoomsList().size(); i++) {
            Room room = rooms.getRoomsList().get(i);
            System.out.println("Nr: " + rooms.getRoomsList().indexOf(room) + " ,pokoj: " + room.getStreetAndNumber());
        }
        System.out.println("");
        System.out.println("Podaj nr pokoju, ktory chcesz zarejestrowac:");
        while (userRoomNrInput == null) {
            try {
                Scanner scanner = new Scanner(System.in);
                userRoomNrInput = scanner.nextLong();
            } catch (Exception e) {
                System.out.println("Podana wartosc jest nieprawidlowa");
            }
        }
        System.out.println("Podaj termin najmu (DD/MM/YYYY)");
        while (userRoomTermInput == null) {
                Scanner scanner = new Scanner(System.in);
                userRoomTermInput = scanner.nextLine();
        }

        for (int i = 0; i < rooms.getRoomsList().size(); i++) {
            Room room = rooms.getRoomsList().get(i);
            if (rooms.getRoomsList().indexOf(room) == userRoomNrInput) {
                room.setStatus(true);
                room.setRegistrationTerm(userRoomTermInput);
                roomUUID = room.getAssigmentId();
            }
        }
        JsonSaver.makeJson(rooms, "src/main/resources/rooms.json");

        System.out.println("");
        System.out.println("Lista osob:");
        System.out.println("");

        Tenants tenants = JsonReader.create(new Tenants(), "src/main/resources/tenants.json");
        for (int i = 0; i < tenants.getTenantsList().size(); i++) {
            Tenant tenant = tenants.getTenantsList().get(i);
            System.out.println("Nr: " + tenants.getTenantsList().indexOf(tenant) + " ,osoba: " + tenant.getName() + " " + tenant.getSurname() );
        }
        System.out.println("");
        System.out.println("Podaj nr osoby, ktorej chcesz wynajac mieszkanie");
        while (userTenantNrInput == null) {
            try {
                Scanner scanner = new Scanner(System.in);
                userTenantNrInput = scanner.nextLong();
            } catch (Exception e) {
                System.out.println("Podana wartosc jest nieprawidlowa");
            }
        }

        for (int i = 0; i < tenants.getTenantsList().size(); i++) {
            Tenant tenant = tenants.getTenantsList().get(i);
            if (tenants.getTenantsList().indexOf(tenant) == userTenantNrInput) {
                tenant.setAssigmentId(roomUUID);
            }
        }
        JsonSaver.makeJson(tenants, "src/main/resources/tenants.json");

        System.out.println("");
        System.out.println("pokoj zostal wynajety");
        Thread.sleep(1000);
        ownerScreen.ownerMenu();
    }
}
