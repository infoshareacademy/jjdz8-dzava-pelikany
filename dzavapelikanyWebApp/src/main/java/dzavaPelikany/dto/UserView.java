package dzavaPelikany.dto;

import dzavaPelikany.domain.Role;

public class UserView {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String role;


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

    public String getRole() {
        return this.role;
    }

    public void setRole(final String role) {
        this.role = role;
    }
}
