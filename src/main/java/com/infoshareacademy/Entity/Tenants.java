package com.infoshareacademy.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tenants {

    private List<Tenant> tenantsList = new ArrayList<>();

    public List<Tenant> getTenantsList() {
        return tenantsList;
    }

    public void addTenant(Tenant...tenants) {
        this.tenantsList.addAll(Arrays.asList(tenants));
    }
}
