package dzavaPelikany.mapper;

import dzavaPelikany.domain.Role;
import dzavaPelikany.dto.RoleView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RoleMapper {

    public RoleView toView(Role role) {
        RoleView roleView = new RoleView();
        roleView.setId(role.getId());
        roleView.setName(role.getName());
        return roleView;
    }

}
