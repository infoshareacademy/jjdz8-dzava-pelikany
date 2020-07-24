package dzavaPelikany.repository;


import dzavaPelikany.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserDao implements Dao<User> {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Optional<User> findUserById(Long userId) {
        return Optional.ofNullable(entityManager.find(User.class, userId));
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Query query = entityManager.createNamedQuery("User.findUserByEmail");
        query.setParameter("email", email);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public List<User> findAll() {
        Query query = entityManager.createNamedQuery("User.findAll");
        return query.getResultList();
    }
}
