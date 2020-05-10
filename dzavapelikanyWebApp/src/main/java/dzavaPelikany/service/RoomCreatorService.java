package dzavaPelikany.service;


import dzavaPelikany.domain.Room;
import dzavaPelikany.domain.Rooms;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class RoomCreatorService {

    Scanner scanner = new Scanner(in);


    private Room roomDetails() {
        String roomLogin = getCorrectRoomLogin();
        System.out.println("Wprowadź ulicę i numer : ");
        String streetAndNumber = scanner.nextLine();
        System.out.println("Wprowadź miasto : ");
        String city = scanner.nextLine();

        System.out.println("Wprowadź powierzchnię pokoju w m2 (przykład : 15.0): ");
        byte area = scanner.nextByte();
        while (area == 0) {
            out.println("Niepoprawna wartość. Spróbuj ponownie: ");
            area = scanner.nextByte();
        }
        System.out.println("Wprowadź cenę w PLN : ");
        double price = scanner.nextDouble();
        while (price == 0) {
            out.println("Niepoprawna wartość. Spróbuj ponownie: ");
            price = scanner.nextDouble();
        }
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


    private void saveRoom(Room room) throws IOException {
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        rooms.addRoom(room);
        JsonSaver.makeJson(rooms, "src/main/resources/rooms.json");
    }

    public void createRoom() throws IOException, InterruptedException {
        Room room = roomDetails();
        saveRoom(room);
        System.out.println("Dodałeś mieszkanie do swojej listy !");
        Thread.sleep(1000);

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
