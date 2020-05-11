package dzavaPelikany.service;

import dzavaPelikany.domain.User;
import dzavaPelikany.repository.OwnerRepository;
import dzavaPelikany.repository.TenantRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.UUID;

@RequestScoped
public class TenantService {

    @EJB
    private TenantRepository tenantRepository;

    public void saveUser(User user) throws IOException {
        tenantRepository.saveUser(user);
    }

    public User findById(UUID id){
        return tenantRepository.findById(id).orElse(null);
    }

    public User findByLogin(String login){
        return tenantRepository.findByLogin(login).orElse(null);
    }

    public void deleteUser(User user) throws IOException {
        tenantRepository.deleteUser(user);
    }
}
