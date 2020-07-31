
package dzavaPelikany.service;


import dzavaPelikany.domain.Room;
import dzavaPelikany.domain.Rooms;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;
import dzavaPelikany.oauth.GoogleLogoutServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.UUID;

import static dzavaPelikany.fileOperation.FilesNames.ROOMS_JSONWEB;

@RequestScoped
public class RoomCreatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomCreatorService.class.getName());

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
        LOGGER.info("room created: " + room);
        return room;
    }


    public void saveRoom(Room room) throws IOException {
        Rooms rooms = JsonReader.create(new Rooms(), ROOMS_JSONWEB);
        rooms.addRoom(room);
        JsonSaver.makeJson(rooms, ROOMS_JSONWEB);
    }



}
