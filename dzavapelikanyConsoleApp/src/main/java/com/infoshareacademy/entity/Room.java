package com.infoshareacademy.entity;

import java.util.UUID;

public class Room {
    private String roomLogin;
    private String streetAndNumber;
    private String city;
    private byte area;
    private double price;
    private UUID assigmentId;
    private String registrationTerm;
    private boolean status;

    public Room(String roomLogin) {
        this.roomLogin = roomLogin;
        this.assigmentId = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomLogin='" + roomLogin + '\'' +
                ", streetAndNumber='" + streetAndNumber + '\'' +
                ", city='" + city + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", registrationTerm='" + registrationTerm + '\'' +
                ", status=" + status +
                '}';
    }

    public String getRoomLogin() {
        return roomLogin;
    }

    public void setRoomLogin(String roomLogin) {
        this.roomLogin = roomLogin;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public byte getArea() {
        return area;
    }

    public void setArea(byte area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UUID getAssigmentId() {
        return assigmentId;
    }

    public void setAssigmentId(UUID assigmentId) {
        assigmentId = assigmentId;
    }

    public String getRegistrationTerm() {
        return registrationTerm;
    }

    public void setRegistrationTerm(String registrationTerm) {
        this.registrationTerm = registrationTerm;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
