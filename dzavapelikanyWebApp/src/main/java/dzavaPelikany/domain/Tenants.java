package dzavaPelikany.domain;

import dzavaPelikany.fileOperation.JsonReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dzavaPelikany.fileOperation.FilesNames.TENANTS_JSON;

public class Tenants {

    private List<Tenant> tenantsList = new ArrayList<>();

    public List<Tenant> getTenantsList() {
        return tenantsList;
    }

    public void addTenant(Tenant...tenants) {
        this.tenantsList.addAll(Arrays.asList(tenants));
    }

    public static boolean tenantExist(String login) {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        for (Tenant tenant : tenants.getTenantsList()) {
            if (tenant.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public Tenant findLogin(String login) {
        for (Tenant tenant : this.tenantsList) {
            if (tenant.getLogin().equals(login)) {
                return tenant;
            }
        }
        return new Tenant(login);
    }


}
