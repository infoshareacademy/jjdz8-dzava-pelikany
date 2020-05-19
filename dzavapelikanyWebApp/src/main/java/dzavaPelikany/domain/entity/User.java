package dzavaPelikany.domain.entity;

import dzavaPelikany.domain.dto.UserDto;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Objects;



public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    @ColumnDefault(value = "2")
    @Enumerated(EnumType.ORDINAL)
    private  UserType userType;

    public User(String name, String surname, UserType userType) {
        this.name = name;
        this.surname = surname;
        this.userType = userType;
    }

    public User(){

    }

    public UserDto createUserDto(){
        return new UserDto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", userType= '" + userType + '\''+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
