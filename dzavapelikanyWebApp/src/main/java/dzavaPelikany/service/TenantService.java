package dzavaPelikany.service;

import dzavaPelikany.domain.Owner;
import dzavaPelikany.domain.Tenant;
import dzavaPelikany.repository.TenantRepository;


import java.io.IOException;
import java.util.UUID;


public class TenantService {

    TenantRepository tenantRepository = new TenantRepository();

    public void saveTenant(Tenant tenant, String path) throws IOException {
        tenantRepository.saveTenant(tenant, path);
    }

    public Tenant findById(UUID id){
        return tenantRepository.findById(id).orElse(null);
    }

    public Tenant findByLogin(String login, String path){
        return tenantRepository.findByLogin(login, path).orElse(null);
    }

    public void deleteTenant(Tenant tenant, String path) throws IOException {
        tenantRepository.deleteTenant(tenant, path);
    }
}
