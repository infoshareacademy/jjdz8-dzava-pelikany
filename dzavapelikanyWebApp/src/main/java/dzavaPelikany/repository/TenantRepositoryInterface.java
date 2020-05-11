package dzavaPelikany.repository;


import dzavaPelikany.domain.Tenant;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public interface TenantRepositoryInterface {

    public void saveTenant (Tenant tenant) throws IOException;
    public Optional<Tenant> findById(UUID id);
    public Optional<Tenant> findByLogin(String login);
    public void deleteTenant(Tenant tenant) throws IOException;
    public boolean contains(Optional<Tenant> tenant);
}
