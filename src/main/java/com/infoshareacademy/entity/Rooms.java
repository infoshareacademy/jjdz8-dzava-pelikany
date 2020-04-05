package com.infoshareacademy.entity;

import com.infoshareacademy.Utilities.JsonReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rooms {

    private List<Room> roomsList = new ArrayList<>();

    public List<Room> getRoomsList() {
        return roomsList;
    }

    public void addRoom(Room... rooms) {
        this.roomsList.addAll(Arrays.asList(rooms));
    }

    public static boolean roomExist(String roomLogin) {
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        for (Room room : rooms.getRoomsList()) {
            if (room.getRoomLogin().equals(roomLogin)) {
                return true;
            }
        }
        return false;
    }

    public Room findRoomLogin(String roomLogin) {
        for (Room room : this.roomsList) {
            if (room.getRoomLogin().equals(roomLogin)) {
                return room;
            }
        }
        return new Room(roomLogin);
    }

}
