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
        String roomLogin = getCorrectRoomLogin();
        System.out.println("Wprowadź ulicę i numer : ");
        String streetAndNumber = scanner.nextLine();
        System.out.println("Wprowadź miasto : ");
        String city = scanner.nextLine();
        System.out.println("Wprowadź powierzchnię pokoju w m2 : ");
        byte area = scanner.nextByte();
        System.out.println("Wprowadź cenę w PLN : ");
        double price = scanner.nextDouble();
        return createRoom(roomLogin, streetAndNumber, city, area, price);
    }

    private Room createRoom(String roomLogin, String streetAndNumber, String city, byte area, double price) {
        Room room = new Room(roomLogin);
        room.setStreetAndNumber(streetAndNumber);
        room.setCity(city);
        room.setArea(area);
        room.setPrice(price);
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

    private String getCorrectRoomLogin() {
        out.println("Wprowadź login: ");
        String roomLogin = scanner.nextLine();
        while (Rooms.roomExist(roomLogin)) {
            out.println("Podany login już istnieje, spróbuj ponownie: ");
            roomLogin = scanner.nextLine();
        }

        return roomLogin;
    }
}
