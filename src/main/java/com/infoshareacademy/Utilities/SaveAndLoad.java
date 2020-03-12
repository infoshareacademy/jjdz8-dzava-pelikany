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
