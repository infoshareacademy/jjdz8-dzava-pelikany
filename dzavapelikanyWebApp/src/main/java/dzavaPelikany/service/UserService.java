package dzavaPelikany.service;

import dzavaPelikany.domain.dto.UserDto;
import dzavaPelikany.domain.entity.User;
import dzavaPelikany.domain.entity.UserType;
import dzavaPelikany.repository.UserDao;
import dzavaPelikany.repository.UserRepositoryDaoInterface;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class UserService {

    @EJB
    UserRepositoryDaoInterface userRepositoryDaoInterface;

    @Inject
    CurrentUserService currentUserService;

    public List<UserDto> getAllUsers(){
        return userRepositoryDaoInterface.getAllUsers();
    }

    public List <User> getAllUsersEntities(){
        return userRepositoryDaoInterface.getAllUsersEntities();
    }

    public int findUserIdByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        return userRepositoryDaoInterface.getUserIdByEmail(email);
    }

    public void updateUserType(int id, UserType userType){
        if(userType == null){
            throw new IllegalArgumentException("UserType cannot be null");
        }
        User user = userRepositoryDaoInterface.getUser(id);
        user.setUserType(userType);
        userRepositoryDaoInterface.updateUser(user);
    }

    
}
