package dzavaPelikany.domain;

import dzavaPelikany.fileOperation.JsonReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static dzavaPelikany.fileOperation.FilesNames.OWNERS_JSON;


public class Owners {

    private List<Owner> ownersList = new ArrayList<>();

    public List<Owner> getOwnersList() {
        return this.ownersList;
    }

    public void addOwner(Owner owner) {
        this.ownersList.add(owner);
    }

    public void deleteOwner(UUID id){
        for (int i=0; i< ownersList.size();i++){
            if(this.ownersList.get(i).getId().equals(id)){
                ownersList.remove(i);
            }
        }

    }



}


