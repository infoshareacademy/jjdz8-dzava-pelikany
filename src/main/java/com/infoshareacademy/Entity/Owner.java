package com.infoshareacademy.Entity;

import java.util.UUID;

public class Owner extends User{

    protected String userLogin;
    protected String userPassword;
    private UUID id;

    public Owner(String userLogin) {
        this.userLogin = userLogin;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Owner{" +
                "userLogin='" + userLogin + '\'' +
                ", id=" + id +
                '}';
    }
}
