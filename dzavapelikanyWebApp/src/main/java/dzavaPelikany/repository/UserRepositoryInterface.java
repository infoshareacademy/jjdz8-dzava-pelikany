package dzavaPelikany.repository;

import dzavaPelikany.domain.UserEntity;
import dzavaPelikany.dto.AuthUserDto;
import dzavaPelikany.dto.UserDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserRepositoryInterface {


    int createUser(UserEntity userEntity);

    AuthUserDto getAuthUserDTO(String email);

    List<UserDto> getAllUsers();

    List<UserDto> getUserDTObyName(String name);

    List<UserDto> getUserDTObyName(String name, String surname);

    void updateUser(UserEntity userEntity);

    int getUserIdByEmail(String email);

    UserEntity getUserEntity(int userId);

    List<UserEntity> getAllUsersEntities();


}
