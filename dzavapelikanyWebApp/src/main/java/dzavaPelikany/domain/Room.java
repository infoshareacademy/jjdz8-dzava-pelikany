package dzavaPelikany.domain;

import java.util.UUID;

public class Room {
    private String roomLogin;
    private String streetAndNumber;
    private String city;
    private Integer area;
    private double price;
    private UUID assigmentId;
    private UUID id;
    private String registrationTerm;
    private boolean status;


    public boolean getStatus() {
        return status;
    }



    public String getTenantLogin() {
        return tenantLogin;
    }

    public void setTenantLogin(String tenantLogin) {
        this.tenantLogin = tenantLogin;
    }

    private String tenantLogin;


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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
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