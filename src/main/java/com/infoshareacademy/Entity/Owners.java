package com.infoshareacademy.Entity;

import com.infoshareacademy.Utilities.JsonReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Owners {

    private List<Owner> ownersList = new ArrayList<>();

    public List<Owner> getOwnersList() {
        return ownersList;
    }

    public void addOwner(Owner... owners) {
        this.ownersList.addAll(Arrays.asList(owners));
    }

    public static boolean ownerExist(String login) {
        Owners owners = JsonReader.create(new Owners(), "src/main/resources/owners.json");
        for (Owner owner : owners.getOwnersList()) {
            if (owner.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public Owner findLogin(String login) {
        for (Owner owner : this.ownersList) {
            if (owner.getLogin().equals(login)) {
                return owner;
            }
        }
        return new Owner(login);
    }


}


