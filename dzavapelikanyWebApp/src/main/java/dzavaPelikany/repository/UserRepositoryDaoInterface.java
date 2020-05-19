package dzavaPelikany.repository;


import dzavaPelikany.domain.dto.UserDto;
import dzavaPelikany.domain.entity.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserRepositoryDaoInterface {

    int createUser(User user);
    List<UserDto> getAllUsers();
    List<UserDto> getUserDtoByName(String name);
    List<UserDto> getUserDtoByLogin(String login);
    void updateUser(User user);
    int getUserIdByEmail(String email);
    User getUser(int id);
    List<User> getAllUsersEntities();


}
