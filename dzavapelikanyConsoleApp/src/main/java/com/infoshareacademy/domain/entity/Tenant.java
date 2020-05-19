package com.infoshareacademy.domain.entity;

import java.util.UUID;

public class Tenant{

    private String login;
    private String name;
    private String surname;
    private String email;
    private UUID id;
    private UUID AssigmentId;

    public UUID getAssigmentId() {
        return AssigmentId;
    }

    public void setAssigmentId(UUID assigmentId) {
        AssigmentId = assigmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public Tenant(String login) {
        this.login = login;

        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }

}
