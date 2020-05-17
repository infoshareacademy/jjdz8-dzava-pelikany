package dzavaPelikany.repository;

import dzavaPelikany.domain.Owner;


import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public interface OwnerRepositoryInterface {

    public void saveOwner (Owner owner) throws IOException;
    public Optional<Owner> findById(UUID id);
    public Optional<Owner> findByLogin(String login);
    public void deleteOwner(Owner owner) throws IOException;
    public boolean contains(Optional<Owner> owner);
}