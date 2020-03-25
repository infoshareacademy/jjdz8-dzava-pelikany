package com.infoshareacademy.Utilities;



import com.infoshareacademy.View.OwnerScreen;
import com.infoshareacademy.Entity.*;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static java.lang.System.*;


public class SaveAndLoad {


    private static Map<Long, Owner> ownerList = new HashMap<>();
    private static Map<Long, Tenant> tenantList = new HashMap<>();
    private static Map<Long, Room> roomList = new HashMap<>();



    Scanner scanner = new Scanner(System.in);
    OwnerScreen ownerScreen = new OwnerScreen();
    private Room roomDetails() {
        System.out.println("Wprowadź ulicę i numer : ");
        String streetAndNumber = scanner.nextLine();
        System.out.println("Wprowadź miasto : ");
        String city = scanner.nextLine();
        System.out.println("Wprowadź powierzchnię pokoju w m2 : ");
        byte area = scanner.nextByte();
        System.out.println("Wprowadź cenę w PLN : ");
        double price = scanner.nextDouble();
        Room room;
        room = new Room(streetAndNumber, city, area, price);
        return room;
    }

    private void saveRoom(Room room) {
        Rooms rooms = JsonReader.create(new Rooms(), "src/main/resources/rooms.json");
        rooms.addRoom(room);
        JsonSaver.makeJson(rooms, "src/main/resources/rooms.json");
    }

    public void createRoom() throws IOException, InterruptedException {
        Room room = roomDetails();
        saveRoom(room);
        System.out.println("Dodałeś mieszkanie do swojej listy !");
        Thread.sleep(1000);
        ownerScreen.ownerMenu();
    }


    private Owner makeOwner() {
        String login = getCorrectOwnerLogin();
        out.println("Wprowadź imię: ");
        String name = scanner.nextLine();
        out.println("Wprowadź nazwisko: ");
        String surname = scanner.nextLine();
        out.println("Wprowadź email: ");
        String email = scanner.nextLine();
        Owner owner;
        owner = new Owner(login);
        owner.setName(name);
        owner.setSurname(surname);
        owner.setEmail(email);
        return owner;
    }

    private void saveOwner(Owner owner) {
        Owners owners = JsonReader.create(new Owners(), "src/main/resources/owners.json");
        owners.addOwner(owner);
        JsonSaver.makeJson(owners, "src/main/resources/owners.json");
    }

    public void makeOwnerAccount() {
        Owner owner = makeOwner();
        saveOwner(owner);
        out.println("\nTwoje dane zostałe zapisane!");
    }

    private Tenant makeTenant() {
        String login = getCorrectTenantLogin();
        out.println("Wprowadź imię: ");
        String name = scanner.nextLine();
        out.println("Wprowadź nazwisko: ");
        String surname = scanner.nextLine();
        out.println("Wprowadź email: ");
        String email = scanner.nextLine();
        Tenant tenant;
        tenant = new Tenant(login);
        tenant.setName(name);
        tenant.setSurname(surname);
        tenant.setEmail(email);
        return tenant;
    }

    private void saveTenant(Tenant tenant) {
        Tenants tenants = JsonReader.create(new Tenants(), "src/main/resources/tenants.json");
        tenants.addTenant(tenant);
        JsonSaver.makeJson(tenants, "src/main/resources/tenants.json");
    }

    public void makeTenantAccount() {
        Tenant tenant = makeTenant();
        saveTenant(tenant);
        out.println("\nTwoje dane zostałe zapisane!");
    }

    private String getCorrectTenantLogin() {
        out.println("Wprowadź login: ");
        String login = scanner.nextLine();
        while (Tenants.tenantExist(login)) {
            out.println("Podany login już istnieje, spróbuj ponownie: ");
            login = scanner.nextLine();
        }

        return login;
    }

    private String getCorrectOwnerLogin() {
        out.println("Wprowadź login: ");
        String login = scanner.nextLine();
        while (Owners.ownerExist(login)) {
            out.println("Podany login już istnieje, spróbuj ponownie: ");
            login = scanner.nextLine();
        }

        return login;
    }

}
