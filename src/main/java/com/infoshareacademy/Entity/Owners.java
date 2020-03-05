package com.infoshareacademy.Entity;

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
}
