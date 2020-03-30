package com.infoshareacademy.utilities;

import com.infoshareacademy.entity.Room;
import com.infoshareacademy.entity.Rooms;
import com.infoshareacademy.file.operation.JsonReader;
import com.infoshareacademy.file.operation.JsonSaver;
import com.infoshareacademy.view.OwnerScreen;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class RoomCreator {

    Scanner scanner = new Scanner(in);
    OwnerScreen ownerScreen = new OwnerScreen();
    private Room roomDetails() {
        out.println("Wprowadź ulicę i numer : ");
        String streetAndNumber = scanner.nextLine();
        out.println("Wprowadź miasto : ");
        String city = scanner.nextLine();
        out.println("Wprowadź powierzchnię pokoju w m2 : ");
        byte area = scanner.nextByte();
        out.println("Wprowadź cenę w PLN : ");
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
        out.println("Dodałeś mieszkanie do swojej listy !");
        Thread.sleep(1000);
        ownerScreen.ownerMenu();
    }
}
