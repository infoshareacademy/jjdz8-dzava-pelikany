package dzavaPelikany.service;


import dzavaPelikany.domain.Room;
import dzavaPelikany.domain.Rooms;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;
import dzavaPelikany.servlets.HomePageServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

import static dzavaPelikany.fileOperation.FilesNames.ROOMS_JSONWEB;
import static java.lang.System.in;
import static java.lang.System.out;

@RequestScoped
public class RoomCreatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomCreatorService.class.getName());



    public Room createRoom(String roomLogin, String streetAndNumber, String city, byte area) {
        Room room = new Room(roomLogin);
        room.setStreetAndNumber(streetAndNumber);
        room.setCity(city);
        room.setArea(area);
        room.setAssigmentId(UUID.randomUUID());
        room.setPrice(0);
        room.setRegistrationTerm("brak");
        room.setStatus(false);
        room.setId(UUID.randomUUID());
        return room;
    }


    public void saveRoom(Room room) throws IOException {
        Rooms rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB);
        rooms.addRoom(room);
        JsonSaver.makeJson(rooms, ROOMS_JSONWEB);
    }



}
