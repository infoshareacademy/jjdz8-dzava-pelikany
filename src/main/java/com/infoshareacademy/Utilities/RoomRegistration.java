package com.infoshareacademy.Utilities;

import com.infoshareacademy.Entity.Owner;
import com.infoshareacademy.Entity.Owners;
import com.infoshareacademy.Entity.Room;
import com.infoshareacademy.Entity.Rooms;
import com.infoshareacademy.View.OwnerScreen;

import java.io.IOException;
import java.util.Scanner;


public class RoomRegistration {

    Scanner scanner = new Scanner(System.in);
    OwnerScreen ownerScreen = new OwnerScreen();
    private Room roomDetails() {
        System.out.println("Wprowadź ulicę i numer : ");
        String streetAndNumber = scanner.nextLine();
        System.out.println("Wprowadź miasto : ");
        String city = scanner.nextLine();
        System.out.println("Wprowadź powierzchnię pokoju w m2 : ");
        byte area = scanner.nextByte();
        System.out.println("Wprowadź cenę w PLN : ");
        double price = scanner.nextDouble();
        Room room;
        room = new Room(streetAndNumber, city, area, price);
        return room;
    }

    private void saveRoom(Room room) {
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        rooms.addRoom(room);
        JsonSaver.makeJson(rooms, "src/main/resources/rooms.json");
    }

    public void createRoom() throws IOException, InterruptedException {
        Room room = roomDetails();
        saveRoom(room);
        System.out.println("Dodałeś mieszkanie do swojej listy !");
        Thread.sleep(1000);
        ownerScreen.ownerMenu();
    }
}


