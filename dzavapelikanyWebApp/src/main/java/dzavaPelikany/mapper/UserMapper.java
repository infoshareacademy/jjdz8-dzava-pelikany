package dzavaPelikany.mapper;


import dzavaPelikany.domain.User;
import dzavaPelikany.dto.UserView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UserMapper {

    public UserView toView(User user) {
        UserView userView = new UserView();
        userView.setId(user.getId());
        userView.setName(user.getName());
        userView.setEmail(user.getEmail());

        //TODO Add setUserType with UserTypeMapper

        return userView;
    }
}
