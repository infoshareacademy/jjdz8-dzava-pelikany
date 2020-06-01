package dzavaPelikany.domain;


import java.util.Objects;
import java.util.UUID;

public class Owner {

    protected String login;
    private String name;
    private String surname;
    private String email;
    private UUID id;
    private String password;

    public Owner(String login) {
        this.login = login;
        this.id = UUID.randomUUID();
    }

    public Owner() {
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Owner owner = (Owner) o;
        return Objects.equals(this.login, owner.login) &&
                Objects.equals(this.name, owner.name) &&
                Objects.equals(this.surname, owner.surname) &&
                Objects.equals(this.email, owner.email) &&
                Objects.equals(this.id, owner.id) &&
                Objects.equals(this.password, owner.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.login);
    }
}
