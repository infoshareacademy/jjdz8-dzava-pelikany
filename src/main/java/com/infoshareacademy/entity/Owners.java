package com.infoshareacademy.entity;

import com.infoshareacademy.file.operation.JsonReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.infoshareacademy.file.operation.FilesNames.OWNERS_JSON;

public class Owners {

    private List<Owner> ownersList = new ArrayList<>();

    public List<Owner> getOwnersList() {
        return ownersList;
    }

    public void addOwner(Owner... owners) {
        this.ownersList.addAll(Arrays.asList(owners));
    }

    public static boolean ownerExist(String login) {
        Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
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


