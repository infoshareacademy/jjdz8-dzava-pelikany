package com.infoshareacademy.Utilities;

import com.infoshareacademy.Entity.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.*;

public class SaveAndLoad {

    private static Map<Long, Room> roomList = new HashMap<>();

    public static Map<Long, Room> roomLoad(){
        //TODO
        return null;
    }
    public static void roomSave(){
        //TODO
    }

    Scanner scanner = new Scanner(in);

    private Owner makeOwner() {
        out.println("Wprowadź login: ");
        String login = scanner.nextLine();
        out.println("Wprowadź imię: ");
        String name = scanner.nextLine();
        out.println("Wprowadź nazwisko: ");
        String surname = scanner.nextLine();
        Owner owner;
        owner = new Owner(login,name,surname);
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
        out.println("Wprowadź login: ");
        String login = scanner.nextLine();
        out.println("Wprowadź imię: ");
        String name = scanner.nextLine();
        out.println("Wprowadź nazwisko: ");
        String surname = scanner.nextLine();
        Tenant tenant;
        tenant = new Tenant(login,name,surname);
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


}
