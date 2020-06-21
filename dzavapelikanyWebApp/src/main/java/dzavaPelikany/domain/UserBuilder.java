package dzavaPelikany.domain;

public class UserBuilder {
    private String name;
    private String surname;
    private String login;
    private String email;
    private Role role = Role.USER;

    public UserBuilder() {
    }

    public static UserBuilder anUserEntity(){
        return new UserBuilder();
    }

    public UserBuilder withName (String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withSurname (String surname) {
        this.surname = surname;
        return this;
    }


    public UserBuilder withEmail (String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withLogin (String login) {
        this.login = login;
        return this;
    }

    public UserBuilder withRole (Role role) {
        this.role = role;
        return this;
    }

    public UserEntity build(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setSurname(surname);
        userEntity.setLogin(login);
        userEntity.setEmail(email);
        userEntity.setRole(role);
        return userEntity;
    }
}
