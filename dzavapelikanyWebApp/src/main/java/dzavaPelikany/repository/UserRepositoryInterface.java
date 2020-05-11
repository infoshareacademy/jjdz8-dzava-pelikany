package dzavaPelikany.repository;

import dzavaPelikany.domain.User;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryInterface {

    public void saveUser (User user) throws IOException;
    public Optional<User> findById(UUID id);
    public Optional<User> findByLogin(String login);
    public void deleteUser(User user) throws IOException;
    public boolean contains(Optional<User> user);
}
