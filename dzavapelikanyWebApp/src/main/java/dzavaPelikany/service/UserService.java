package dzavaPelikany.service;

import dzavaPelikany.domain.UserEntity;
import dzavaPelikany.repository.UserRepositoryInterface;
import dzavaPelikany.servlets.HomePageServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserService {

    @EJB
    UserRepositoryInterface userRepositoryInterface;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class.getName());

    public int createUser(UserEntity userEntity) {
        return userRepositoryInterface.createUser(userEntity);
    }

}
