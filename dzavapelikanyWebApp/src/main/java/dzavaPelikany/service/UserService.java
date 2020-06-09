package dzavaPelikany.service;

import dzavaPelikany.domain.UserEntity;
import dzavaPelikany.repository.UserRepositoryInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserService {

    @EJB
    UserRepositoryInterface userRepositoryInterface;

    Logger logger = LoggerFactory.getLogger("dzavapelikany.services");

    public int createUser(UserEntity userEntity) {
        return userRepositoryInterface.createUser(userEntity);
    }

}
