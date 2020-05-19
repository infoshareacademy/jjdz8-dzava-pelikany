package com.infoshareacademy.domain.entity;

import java.util.UUID;

public class Owner {

    protected String login;
    private String name;
    private String surname;
    private String email;
    private UUID id;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Owner(String login) {
        this.login = login;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Owner{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }


}
