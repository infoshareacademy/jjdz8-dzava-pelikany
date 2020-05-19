package dzavaPelikany.repository;

import dzavaPelikany.domain.dto.UserDto;
import dzavaPelikany.domain.entity.User;
import dzavaPelikany.domain.entity.UserBuilder;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserDao implements UserRepositoryDaoInterface{


    @PersistenceContext(unitName = "dzavapelikany-hibernate")
    private EntityManager entityManager;

    @Override
    public int createUser(User user) {
        User newUser = UserBuilder.anUser()
                .withName(user.getName())
                .withEmail(user.getEmail())
                .withSurname(user.getSurname())
                .build();
        entityManager.persist(newUser);
        return newUser.getId();
    }

    @Override
    public List<UserDto> getAllUsers() {
        return entityManager
                .createQuery("select new dzavaPelikany.domain.dto.UserDto(u.id, u.name, u.surname, u.email) FROM User u " + "WHERE  u.UserType=:level"
                , UserDto.class)
                .getResultList();
    }

    @Override
    public List<UserDto> getUserDtoByName(String name) {
       try{
           return entityManager
                   .createQuery("SELECT new dzavaPelikany.domain.dto.UserDto(u.id, u.name, u.surname, u.email) FROM User u " +
                           "WHERE " +
                           "lower(u.name) LIKE :name or lower(u.surname) LIKE :name"
                   , UserDto.class)
                   .setParameter("name", "%" + name + "%")
                   .getResultList();
       } catch (NoResultException e) {
           return new ArrayList<>();
       }
    }

    @Override
    public List<UserDto> getUserDtoByLogin(String login) {
        return null;
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }

    @Override
    public int getUserIdByEmail(String email) {
        try {
            return (int) entityManager
                    .createQuery("SELECT u.id FROM User u WHERE u.email= :email")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return 0;
        }
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsersEntities() {
        return entityManager
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }
}
