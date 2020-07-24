package dzavaPelikany.domain;


import java.util.Objects;
import java.util.UUID;

public class Tenant {

    protected String login;
    private String name;
    private String surname;
    private String email;
    private UUID id;
    private String password;

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

    private UUID AssigmentId;

    public UUID getAssigmentId() {
        return AssigmentId;
    }

    public void setAssigmentId(UUID assigmentId) {
        AssigmentId = assigmentId;
    }

    public Tenant(){}

    public Tenant(String login) {
        this.login = login;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", password='" + password + " "+
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Tenant tenant = (Tenant) o;
        return Objects.equals(this.login, tenant.login) &&
                Objects.equals(this.name, tenant.name) &&
                Objects.equals(this.surname, tenant.surname) &&
                Objects.equals(this.email, tenant.email) &&
                Objects.equals(this.id, tenant.id) &&
                Objects.equals(this.password, tenant.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.login);
    }
}