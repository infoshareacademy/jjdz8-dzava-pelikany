package dzavaPelikany.repository;

import dzavaPelikany.domain.Owner;
import dzavaPelikany.domain.Owners;

import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;


import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static dzavaPelikany.fileOperation.FilesNames.OWNERS_JSONWEB;

public class OwnerRepository implements OwnerRepositoryInterface{

    @Override
    public void saveOwner(Owner owner) throws IOException {
            Owners owners = JsonReader.create(new Owners(), OWNERS_JSONWEB);
            owners.addOwner(owner);
            JsonSaver.makeJson(owners, OWNERS_JSONWEB);

    }

    @Override
    public Optional<Owner> findById(UUID id) {
        Owners owners = JsonReader.create(new Owners(), OWNERS_JSONWEB);
        return Optional.ofNullable(owners.getOwnersList().stream().filter(o->o.getId().equals(id)).findFirst().orElse(null));
    }

    @Override
    public Optional<Owner> findByLogin(String login) {
        Owners owners = JsonReader.create(new Owners(), OWNERS_JSONWEB);
        return Optional.ofNullable(owners.getOwnersList().stream().filter(o->o.getLogin().equals(login)).findFirst().orElse(null));
    }

    @Override
    public void deleteOwner(Owner owner) throws IOException {
        Owners owners = JsonReader.create(new Owners(), OWNERS_JSONWEB);
        owners.deleteOwner(owner.getId());
        JsonSaver.makeJson(owners, OWNERS_JSONWEB);

    }

    @Override
    public boolean contains(Optional<Owner> owner) {
        if (owner.isEmpty()) return false;
        else {
            Owners owners = JsonReader.create(new Owners(), OWNERS_JSONWEB);
            return owners.getOwnersList().contains(owner.get());
        }
    }
}
