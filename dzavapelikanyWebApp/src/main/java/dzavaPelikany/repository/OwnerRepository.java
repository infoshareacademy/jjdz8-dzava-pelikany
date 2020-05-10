package dzavaPelikany.repository;

import dzavaPelikany.domain.Owner;
import dzavaPelikany.domain.Owners;
import dzavaPelikany.domain.User;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static dzavaPelikany.fileOperation.FilesNames.OWNERS_JSON;

public class OwnerRepository implements UserRepositoryInterface{
    @Override
    public void saveUser(User user) throws IOException {
            Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
            owners.addOwner((Owner)user);
            JsonSaver.makeJson(owners, OWNERS_JSON);


    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public boolean contains(Optional<User> user) {
        return false;
    }
}
