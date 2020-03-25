package com.infoshareacademy.Entity;

public class Room {
    private String streetAndNumber;
    private String city;
    private byte area;
    private double price;

//    private Long id;
//    private UUID flatId;
//    private boolean status;

    public Room(String streetAndNumber, String city, byte area, double price) {
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
}
