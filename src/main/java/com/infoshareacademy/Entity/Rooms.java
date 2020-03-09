package com.infoshareacademy.Entity;

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
}
