package dzavaPelikany.mapper;

import com.google.api.services.oauth2.model.Userinfoplus;
import dzavaPelikany.dto.UserGoogleView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class GoogleUserMapper {

    public UserGoogleView mapGoogleResponseToUserGoogleView(Userinfoplus info) {
        UserGoogleView userView = new UserGoogleView();
        userView.setEmail(info.getEmail());
        userView.setName(info.getName());
        return userView;
    }
}
