package dzavaPelikany.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Tenants {

    private List<Tenant> tenantsList = new ArrayList<>();

    public List<Tenant> getTenantsList() {
        return this.tenantsList;
    }

    public void addTenant(Tenant tenant) {
        this.tenantsList.add(tenant);
    }

    public void deleteTenant(UUID id){
        for(int i=0; i< tenantsList.size();i++){
            if(this.tenantsList.get(i).getId().equals(id)){
                tenantsList.remove(i);
            }
        }
    }


}
