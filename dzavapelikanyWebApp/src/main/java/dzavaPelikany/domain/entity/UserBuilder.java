package dzavaPelikany.domain.entity;

public class UserBuilder {

    private String name;
    private String surname;
    private String email;
    private UserType userType;

    private UserBuilder(){

    }

    public static UserBuilder anUser(){
        return new UserBuilder();
    }

    public UserBuilder withName(String name){
        this.name = name;
        return this;
    }

    public UserBuilder withSurname(String surname){
        this.surname = surname;
        return this;
    }

    public UserBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public UserBuilder withUserType(UserType userType){
        this.userType = userType;
        return this;
    }

    public User build(){
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setUserType(userType);
        return user;
    }
}
