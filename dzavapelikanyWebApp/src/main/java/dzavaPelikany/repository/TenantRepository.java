package dzavaPelikany.repository;

import dzavaPelikany.domain.Tenant;
import dzavaPelikany.domain.Tenants;
import dzavaPelikany.domain.User;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static dzavaPelikany.fileOperation.FilesNames.TENANTS_JSON;

public class TenantRepository implements UserRepositoryInterface{
    @Override
    public void saveUser(User user) throws IOException {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        tenants.addTenant((Tenant) user );
        JsonSaver.makeJson(tenants, TENANTS_JSON);

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
