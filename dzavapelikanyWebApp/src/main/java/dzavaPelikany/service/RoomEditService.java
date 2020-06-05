package dzavaPelikany.service;



import dzavaPelikany.domain.Rooms;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;

import java.io.IOException;
import java.util.Scanner;

import static dzavaPelikany.fileOperation.FilesNames.ROOMS_JSONWEB;


public class RoomEditService {

    Scanner scanner = new Scanner(System.in);


    public void editRoomStreetAndNumber() throws IOException, InterruptedException {
        System.out.println("Wprowadź login pokoju: ");
        Rooms rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB);
        String roomLogin = scanner.nextLine();
        System.out.println("Wprowadź nową ulicę i numer : ");
        setNewStreetAndNumber(roomLogin);
        System.out.println("Twoje zmiany zostały zapisane!");
        Thread.sleep(1000);

    }

    public void setNewStreetAndNumber(String roomLogin) throws IOException {
        Rooms rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB);
        rooms.findRoomLogin(roomLogin).setStreetAndNumber(scanner.nextLine());
        JsonSaver.makeJson(rooms, ROOMS_JSONWEB);
    }

    public void editRoomCity() throws IOException, InterruptedException {
        System.out.println("Wprowadź login pokoju: ");
        Rooms rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB);
        String roomLogin = scanner.nextLine();
        System.out.println("Wprowadź nowe miasto : ");
        setNewCity(roomLogin);
        System.out.println("Twoje zmiany zostały zapisane!");
        Thread.sleep(1000);

    }

    public void setNewCity(String roomLogin) throws IOException {
        Rooms rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB);
        rooms.findRoomLogin(roomLogin).setCity(scanner.nextLine());
        JsonSaver.makeJson(rooms, ROOMS_JSONWEB);
    }

    public void editRoomArea() throws IOException, InterruptedException {
        System.out.println("Wprowadź login pokoju: ");
        Rooms rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB);
        String roomLogin = scanner.nextLine();
        System.out.println("Wprowadź nową powierzchnię pokoju w m2  : ");
        setNewArea(roomLogin);
        System.out.println("Twoje zmiany zostały zapisane!");
        Thread.sleep(1000);

    }

    public void setNewArea(String roomLogin) throws IOException {
        Rooms rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB);
        rooms.findRoomLogin(roomLogin).setArea(scanner.nextByte());
        JsonSaver.makeJson(rooms, ROOMS_JSONWEB);
    }

    public void editRoomPrice() throws IOException, InterruptedException {
        System.out.println("Wprowadź login pokoju: ");
        Rooms rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB);
        String roomLogin = scanner.nextLine();
        System.out.println("Wprowadź nową powierzchnię pokoju w m2  : ");
        setNewPrice(roomLogin);
        System.out.println("Twoje zmiany zostały zapisane!");
        Thread.sleep(1000);

    }

    public void setNewPrice(String roomLogin) throws IOException {
        Rooms rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB);
        rooms.findRoomLogin(roomLogin).setPrice(scanner.nextDouble());
        JsonSaver.makeJson(rooms, ROOMS_JSONWEB);
    }

}
