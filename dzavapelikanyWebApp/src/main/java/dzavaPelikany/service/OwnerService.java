package dzavaPelikany.service;

import dzavaPelikany.domain.User;
import dzavaPelikany.repository.OwnerRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.UUID;

@RequestScoped
public class OwnerService {

    @EJB
    private OwnerRepository ownerRepository;

    public void saveUser(User user) throws IOException {
        ownerRepository.saveUser(user);
    }

    public User findById(UUID id){
        return ownerRepository.findById(id).orElse(null);
    }

    public User findByLogin(String login){
        return ownerRepository.findByLogin(login).orElse(null);
    }

    public void deleteUser(User user) throws IOException {
        ownerRepository.deleteUser(user);
    }
}
