package dzavaPelikany.dto;

import dzavaPelikany.domain.Role;

public class UserView {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Role role;
    private String login;
    private String password;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
