package dzavaPelikany.repository;


import dzavaPelikany.domain.Tenant;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public interface TenantRepositoryInterface {

    public void saveTenant (Tenant tenant, String path) throws IOException;
    public Optional<Tenant> findById(UUID id);
    public Optional<Tenant> findByLogin(String login, String path);
    public void deleteTenant(Tenant tenant, String path) throws IOException;
    public boolean contains(Optional<Tenant> tenant);
}
