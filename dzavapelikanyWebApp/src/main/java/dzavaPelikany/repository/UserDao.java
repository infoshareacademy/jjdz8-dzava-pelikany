package dzavaPelikany.repository;

import dzavaPelikany.domain.UserBuilder;
import dzavaPelikany.domain.UserEntity;
import dzavaPelikany.dto.AuthUserDto;
import dzavaPelikany.dto.UserDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Stateless
public class UserDao implements UserRepositoryInterface {

    @PersistenceContext(unitName = "dzavapelikany")
    private EntityManager entityManager;

    Logger logger = LoggerFactory.getLogger("dzavaPelikany.repository");




    @Override
    public int createUser(UserEntity userEntity) {
        UserEntity newUserEntity = UserBuilder.anUserEntity()
                .withName(userEntity.getName())
                .withSurname(userEntity.getSurname())
                .withLogin(userEntity.getLogin())
                .withEmail(userEntity.getEmail())
                .build();
        entityManager.persist(newUserEntity);
        logger.info("new user created: " + userEntity + " name: " + userEntity.getName() + " surname:" + userEntity.getSurname());
    return newUserEntity.getId();
    }

    @Override
    public AuthUserDto getAuthUserDTO(String email) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public List<UserDto> getUserDTObyName(String name) {
        return null;
    }

    @Override
    public List<UserDto> getUserDTObyName(String name, String surname) {
        return null;
    }

    @Override
    public void updateUser(UserEntity userEntity) {

    }

    @Override
    public int getUserIdByEmail(String email) {
        return 0;
    }

    @Override
    public UserEntity getUserEntity(int userId) {
        return null;
    }

    @Override
    public List<UserEntity> getAllUsersEntities() {
        return null;
    }
}
