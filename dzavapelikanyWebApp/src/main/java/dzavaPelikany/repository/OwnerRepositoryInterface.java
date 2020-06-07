package dzavaPelikany.repository;

import dzavaPelikany.domain.Owner;


import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public interface OwnerRepositoryInterface {

    public void saveOwner (Owner owner, String path) throws IOException;
    public Optional<Owner> findById(UUID id);
    public Optional<Owner> findByLogin(String login, String path);
    public void deleteOwner(Owner owner, String path) throws IOException;
    public boolean contains(Optional<Owner> owner);
}
