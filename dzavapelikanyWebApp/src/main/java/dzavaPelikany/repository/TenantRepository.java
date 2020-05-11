package dzavaPelikany.repository;

import dzavaPelikany.domain.Tenant;
import dzavaPelikany.domain.Tenants;
import dzavaPelikany.domain.User;
import dzavaPelikany.fileOperation.FilesNames;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;

import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static dzavaPelikany.fileOperation.FilesNames.TENANTS_JSON;

@RequestScoped
public class TenantRepository implements UserRepositoryInterface{

    @Override
    public void saveUser(User user) throws IOException {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        tenants.addTenant((Tenant) user );
        JsonSaver.makeJson(tenants, TENANTS_JSON);
    }

    @Override
    public Optional<User> findById(UUID id) {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        return Optional.ofNullable(tenants.getTenantsList().stream().filter(t->t.getId().equals(id)).findFirst().orElse(null));
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        return Optional.ofNullable(tenants.getTenantsList().stream().filter(t->t.getLogin().equals(login)).findFirst().orElse(null));
    }

    @Override
    public void deleteUser(User user) throws IOException {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        tenants.deleteTenant(user.getId());
        JsonSaver.makeJson(tenants, TENANTS_JSON);
    }

    @Override
    public boolean contains(Optional<User> user) {
        if (user.isEmpty()) return false;
        else {
            Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
            return tenants.getTenantsList().contains(user.get());

        }
    }
}
