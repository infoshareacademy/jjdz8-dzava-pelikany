package dzavaPelikany.service;

import dzavaPelikany.domain.Owner;

import dzavaPelikany.repository.OwnerRepository;


import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.UUID;

@RequestScoped
public class OwnerService {


    private OwnerRepository ownerRepository = new OwnerRepository();

    public void saveOwner(Owner owner, String path) throws IOException {
        ownerRepository.saveOwner(owner, path);
    }

    public Owner findById(UUID id){
        return ownerRepository.findById(id).orElse(null);
    }

    public Owner findByLogin(String login, String path){
        return ownerRepository.findByLogin(login, path).orElse(null);
    }

    public void deleteOwner(Owner owner, String path) throws IOException {
        ownerRepository.deleteOwner(owner, path);
    }
}
