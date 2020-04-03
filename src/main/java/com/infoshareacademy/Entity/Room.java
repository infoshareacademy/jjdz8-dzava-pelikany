package com.infoshareacademy.Entity;

public class Room {

    protected String roomLogin;
    private String streetAndNumber;
    private String city;

    private byte area;
    private double price;

    //    private Long id;
    //    private UUID flatId;
    //    private boolean status;


    public String getRoomLogin() {
        return roomLogin;
    }

    public void setRoomLogin(String roomLogin) {
        this.roomLogin = roomLogin;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getCity() {
        return city;
    }

    public byte getArea() {
        return area;
    }

    public double getPrice() {
        return price;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setArea(byte area) {
        this.area = area;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Room(String roomLogin) {
        this.roomLogin = roomLogin;
    }

//    public Room(String streetAndNumber, String city, byte area, double price) {
//        this.streetAndNumber = streetAndNumber;
//        this.city = city;
//        this.area = area;
//        this.price = price;
//    }


    @Override
    public String toString() {
        return "Room{" +
                "roomLogin='" + roomLogin + '\'' +
                ", streetAndNumber='" + streetAndNumber + '\'' +
                ", city='" + city + '\'' +
                ", area=" + area +
                ", price=" + price +
                '}';
    }
}
