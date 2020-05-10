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
        return ownersList;
    }

    public void addOwner(Owner owner) {
        this.ownersList.add(owner);
    }

    public void deleteOwner(UUID id){

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


