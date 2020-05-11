package dzavaPelikany.service;

import dzavaPelikany.domain.Tenant;
import dzavaPelikany.repository.TenantRepository;

import javax.enterprise.context.RequestScoped;

import java.io.IOException;
import java.util.UUID;

@RequestScoped
public class TenantService {

    TenantRepository tenantRepository = new TenantRepository();

    public void saveTenant(Tenant tenant) throws IOException {
        tenantRepository.saveTenant(tenant);
    }

    public Tenant findById(UUID id){
        return tenantRepository.findById(id).orElse(null);
    }

    public Tenant findByLogin(String login){
        return tenantRepository.findByLogin(login).orElse(null);
    }

    public void deleteTenant(Tenant tenant) throws IOException {
        tenantRepository.deleteTenant(tenant);
    }
}
