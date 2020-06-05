package dzavaPelikany.repository;

import dzavaPelikany.domain.Tenant;
import dzavaPelikany.domain.Tenants;

import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static dzavaPelikany.fileOperation.FilesNames.TENANTS_JSONWEB;

public class TenantRepository implements TenantRepositoryInterface{

    @Override
    public void saveTenant(Tenant tenant) throws IOException {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSONWEB);
        tenants.addTenant(tenant);
        JsonSaver.makeJson(tenants, TENANTS_JSONWEB);
    }


    @Override
    public Optional<Tenant> findById(UUID id) {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSONWEB);
        return Optional.ofNullable(tenants.getTenantsList().stream().filter(t->t.getId().equals(id)).findFirst().orElse(null));
    }

    @Override
    public Optional<Tenant> findByLogin(String login) {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSONWEB);
        return Optional.ofNullable(tenants.getTenantsList().stream().filter(t->t.getLogin().equals(login)).findFirst().orElse(null));
    }

    @Override
    public void deleteTenant(Tenant tenant) throws IOException {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSONWEB);
        tenants.deleteTenant(tenant.getId());
        JsonSaver.makeJson(tenants, TENANTS_JSONWEB);
    }

    @Override
    public boolean contains(Optional<Tenant> tenant) {
        if (tenant.isEmpty()) return false;
        else {
            Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSONWEB);
            return tenants.getTenantsList().contains(tenant.get());

        }
    }
}
