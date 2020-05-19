package dzavaPelikany.domain.dto;

import dzavaPelikany.domain.entity.UserType;

import java.util.Objects;
import java.util.UUID;

public class UserDto {

    private String login;
    private String name;
    private String surname;
    private String email;
    private UUID id;
    private UserType UserType;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserType getUserType() {
        return UserType;
    }

    public void setUserType(UserType userType) {
        UserType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(login, userDto.login) &&
                Objects.equals(name, userDto.name) &&
                Objects.equals(surname, userDto.surname) &&
                Objects.equals(email, userDto.email) &&
                Objects.equals(id, userDto.id) &&
                UserType == userDto.UserType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, surname, email, id, UserType);
    }
}
