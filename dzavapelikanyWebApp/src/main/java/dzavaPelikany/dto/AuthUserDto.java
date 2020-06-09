package dzavaPelikany.dto;

import dzavaPelikany.domain.Role;

public class AuthUserDto {

    private int id;
    private Role role;

    public AuthUserDto(int id, Role role) {
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
