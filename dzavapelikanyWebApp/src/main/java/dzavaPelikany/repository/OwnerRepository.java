package dzavaPelikany.repository;

import dzavaPelikany.domain.Owner;
import dzavaPelikany.domain.Owners;
import dzavaPelikany.domain.User;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;

import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static dzavaPelikany.fileOperation.FilesNames.OWNERS_JSON;

@RequestScoped
public class OwnerRepository implements UserRepositoryInterface{

    @Override
    public void saveUser(User user) throws IOException {
            Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
            owners.addOwner((Owner)user);
            JsonSaver.makeJson(owners, OWNERS_JSON);

    }

    @Override
    public Optional<User> findById(UUID id) {
        Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
        return Optional.ofNullable(owners.getOwnersList().stream().filter(o->o.getId().equals(id)).findFirst().orElse(null));
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
        return Optional.ofNullable(owners.getOwnersList().stream().filter(o->o.getLogin().equals(login)).findFirst().orElse(null));
    }

    @Override
    public void deleteUser(User user) throws IOException {
        Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
        owners.deleteOwner(user.getId());
        JsonSaver.makeJson(owners, OWNERS_JSON);

    }

    @Override
    public boolean contains(Optional<User> user) {
        if (user.isEmpty()) return false;
        else {
            Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
            return owners.getOwnersList().contains(user.get());
        }
    }
}
