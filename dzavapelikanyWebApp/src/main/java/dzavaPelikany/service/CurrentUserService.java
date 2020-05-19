package dzavaPelikany.service;

import java.io.Serializable;

public class CurrentUserService implements Serializable {

    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
