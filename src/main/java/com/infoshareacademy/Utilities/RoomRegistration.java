package com.infoshareacademy.Utilities;

import com.infoshareacademy.Entity.Owner;
import com.infoshareacademy.Entity.Owners;

import java.util.Scanner;


public class RoomRegistration {

    Scanner scanner = new Scanner(System.in);

    private Owner makeOwner() {
        String ownerLogin = scanner.nextLine();
        Owner owner = new Owner(ownerLogin);
        return owner;
    }

    private void saveOwner(Owner owner) {
        Owners owners = JsonReader.create(new Owners(), "src/main/resources/owners.json");
        owners.addOwner(owner);
        JsonSaver.makeJson(owners, "src/main/resources/owners.json");
    }

    public void makeOwnerAccount() {
        System.out.println("Wprowadź login: ");
        Owner owner = makeOwner();
        saveOwner(owner);
    }
}


