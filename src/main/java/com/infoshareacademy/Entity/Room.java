package com.infoshareacademy.Entity;

import java.util.UUID;

public class Room {
    private String streetAndNumber;
    private String city;
    private byte area;
    private double price;
    private UUID assigmentId;
    private String registrationTerm;
    private boolean status;

    public Room(String streetAndNumber, String city, byte area, double price) {
        this.assigmentId = UUID.randomUUID();
        this.streetAndNumber = streetAndNumber;
        this.city = city;
        this.area = area;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "streetAndNumber='" + streetAndNumber + '\'' +
                ", city='" + city + '\'' +
                ", area=" + area +
                ", price=" + price +
                '}';
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
