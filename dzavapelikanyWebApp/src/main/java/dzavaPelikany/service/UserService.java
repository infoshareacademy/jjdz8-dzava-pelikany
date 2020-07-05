package dzavaPelikany.service;

import dzavaPelikany.domain.User;
import dzavaPelikany.dto.UserGoogleView;
import dzavaPelikany.dto.UserView;
import dzavaPelikany.mapper.UserMapper;
import dzavaPelikany.repository.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Optional;

@Stateless
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class.getName());


   @EJB
   private Dao<User> userDao;

   @Inject
    UserMapper userMapper;

   public void save(User user){
       userDao.save(user);
   }

   public UserView getUserById(Long userId) {
       User foundUser = userDao.findUserById(userId).orElseThrow();
       if ((foundUser == null)){
           return null;
       }
       return userMapper.toView(foundUser);
   }

   public User create(UserGoogleView userGoogleView){
      User user = new User();
      user.setName(userGoogleView.getName());
      user.setEmail(userGoogleView.getEmail());
      //TODO setUserType z roleDao
       save(user);
       return user;
   }

   public UserView login(UserGoogleView userGoogleView){
       User user = userDao.findUserByEmail(userGoogleView.getEmail()).orElseGet(()->create(userGoogleView));
       return userMapper.toView(user);
   }






}
