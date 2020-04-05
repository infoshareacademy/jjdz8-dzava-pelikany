package com.infoshareacademy.utilities;

import com.infoshareacademy.view.RoomEditScreen;
import com.infoshareacademy.entity.Rooms;
import com.infoshareacademy.file.operation.JsonReader;
import com.infoshareacademy.file.operation.JsonSaver;

import java.io.IOException;
import java.util.Scanner;

public class RoomEdit {

    Scanner scanner = new Scanner(System.in);
    RoomEditScreen roomEditScreen = new RoomEditScreen();

    public void editRoomStreetAndNumber() throws IOException, InterruptedException {
        System.out.println("Wprowadź login pokoju: ");
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        String roomLogin = scanner.nextLine();
        System.out.println("Wprowadź nową ulicę i numer : ");
        setNewStreetAndNumber(roomLogin);
        System.out.println("Twoje zmiany zostały zapisane!");
        Thread.sleep(1000);
        roomEditScreen.roomEditMenu();
    }

    public void setNewStreetAndNumber(String roomLogin) {
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        rooms.findRoomLogin(roomLogin).setStreetAndNumber(scanner.nextLine());
        JsonSaver.makeJson(rooms, "src/main/resources/rooms.json");
    }

    public void editRoomCity() throws IOException, InterruptedException {
        System.out.println("Wprowadź login pokoju: ");
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        String roomLogin = scanner.nextLine();
        System.out.println("Wprowadź nowe miasto : ");
        setNewCity(roomLogin);
        System.out.println("Twoje zmiany zostały zapisane!");
        Thread.sleep(1000);
        roomEditScreen.roomEditMenu();
    }

    public void setNewCity(String roomLogin) {
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        rooms.findRoomLogin(roomLogin).setCity(scanner.nextLine());
        JsonSaver.makeJson(rooms, "src/main/resources/rooms.json");
    }

    public void editRoomArea() throws IOException, InterruptedException {
        System.out.println("Wprowadź login pokoju: ");
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        String roomLogin = scanner.nextLine();
        System.out.println("Wprowadź nową powierzchnię pokoju w m2  : ");
        setNewArea(roomLogin);
        System.out.println("Twoje zmiany zostały zapisane!");
        Thread.sleep(1000);
        roomEditScreen.roomEditMenu();
    }

    public void setNewArea(String roomLogin) {
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        rooms.findRoomLogin(roomLogin).setArea(scanner.nextByte());
        JsonSaver.makeJson(rooms, "src/main/resources/rooms.json");
    }

    public void editRoomPrice() throws IOException, InterruptedException {
        System.out.println("Wprowadź login pokoju: ");
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        String roomLogin = scanner.nextLine();
        System.out.println("Wprowadź nową powierzchnię pokoju w m2  : ");
        setNewPrice(roomLogin);
        System.out.println("Twoje zmiany zostały zapisane!");
        Thread.sleep(1000);
        roomEditScreen.roomEditMenu();
    }

    public void setNewPrice(String roomLogin) {
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        rooms.findRoomLogin(roomLogin).setPrice(scanner.nextDouble());
        JsonSaver.makeJson(rooms, "src/main/resources/rooms.json");
    }

}
