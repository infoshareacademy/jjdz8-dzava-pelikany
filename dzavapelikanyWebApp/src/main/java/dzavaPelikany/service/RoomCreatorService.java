
package dzavaPelikany.service;


import dzavaPelikany.domain.Room;
import dzavaPelikany.domain.Rooms;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;

import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

import static dzavaPelikany.fileOperation.FilesNames.ROOMS_JSONWEB;
import static java.lang.System.in;
import static java.lang.System.out;

@RequestScoped
public class RoomCreatorService {



    public Room createRoom(String roomLogin, String streetAndNumber, String city, Integer area, double price) {
        Room room = new Room(roomLogin);
        room.setStreetAndNumber(streetAndNumber);
        room.setCity(city);
        room.setArea(area);
        room.setAssigmentId(UUID.randomUUID());
        room.setPrice(price);
        room.setRegistrationTerm("brak");
        room.setStatus(false);
        room.setId(UUID.randomUUID());
        room.setTenantLogin("");
        return room;
    }


    public void saveRoom(Room room) throws IOException {
        Rooms rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB);
        rooms.addRoom(room);
        JsonSaver.makeJson(rooms, ROOMS_JSONWEB);
    }



}
