package com.infoshareacademy.Entity;

import java.util.UUID;

public class Owner {

    protected String login;
    protected String name;
    protected String surname;
    private UUID id;

    public Owner(String login, String name,String surname) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Owner{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }
}
