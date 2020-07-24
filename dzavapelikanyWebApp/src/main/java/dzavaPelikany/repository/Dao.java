package dzavaPelikany.repository;


import dzavaPelikany.domain.User;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface Dao<T> {

    void save(T t);

    void update(T t);

    Optional<T> findUserByEmail(String email);

    List<T> findAll();

    Optional<T> findUserById(Long id);

}
