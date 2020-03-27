package com.infoshareacademy.Utilities;

import com.infoshareacademy.Entity.Rooms;

import java.util.Scanner;

public class RoomEdit {

    Scanner scanner = new Scanner(System.in);

    public void editRoomStreetAndNumber() {
        System.out.println("Wprowadź login pokoju: ");
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        String roomLogin = scanner.nextLine();
        System.out.println("Wprowadź nową ulicę i numer : ");
        setNewStreetAndNumber(roomLogin);
    }

    public void setNewStreetAndNumber(String roomLogin) {
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        rooms.findRoomLogin(roomLogin).setStreetAndNumber(scanner.nextLine());
        JsonSaver.makeJson(rooms, "src/main/resources/rooms.json");
    }

    public void editRoomCity() {
        System.out.println("Wprowadź login pokoju: ");
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        String roomLogin = scanner.nextLine();
        System.out.println("Wprowadź nowe miasto : ");
        setNewCity(roomLogin);
    }

    public void setNewCity(String roomLogin) {
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        rooms.findRoomLogin(roomLogin).setCity(scanner.nextLine());
        JsonSaver.makeJson(rooms, "src/main/resources/rooms.json");
    }

    public void editRoomArea() {
        System.out.println("Wprowadź login pokoju: ");
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        String roomLogin = scanner.nextLine();
        System.out.println("Wprowadź nową powierzchnię pokoju w m2  : ");
        setNewArea(roomLogin);
    }

    public void setNewArea(String roomLogin) {
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        rooms.findRoomLogin(roomLogin).setArea(scanner.nextByte());
        JsonSaver.makeJson(rooms, "src/main/resources/rooms.json");
    }

    public void editRoomPrice() {
        System.out.println("Wprowadź login pokoju: ");
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        String roomLogin = scanner.nextLine();
        System.out.println("Wprowadź nową powierzchnię pokoju w m2  : ");
        setNewPrice(roomLogin);
    }

    public void setNewPrice(String roomLogin) {
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        rooms.findRoomLogin(roomLogin).setPrice(scanner.nextDouble());
        JsonSaver.makeJson(rooms, "src/main/resources/rooms.json");
    }

}
