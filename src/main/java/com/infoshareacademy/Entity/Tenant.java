package com.infoshareacademy.Entity;

import java.util.UUID;

public class Tenant{

    protected String login;
    protected String name;
    protected String surname;
    private UUID id;

    public Tenant(String login, String name, String surname) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }
}
