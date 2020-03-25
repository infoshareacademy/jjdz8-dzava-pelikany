package com.infoshareacademy.Utilities;

import com.infoshareacademy.Entity.Tenants;
import java.util.Scanner;
import static java.lang.System.*;

public class TenantEdit {

    Scanner scanner = new Scanner(in);

    public void editTenantLogin() {
        out.println("Wprowadź dotychczasowy login: ");
        String login = scanner.nextLine();
        out.println("Wprowadź nowy login: ");
        String newLogin = scanner.nextLine();
        setNewLogin(login,newLogin);
        out.println("Dane zostały zmienione!");
    }

    public void setNewLogin (String login, String newLogin){
        Tenants tenants = JsonReader.create(new Tenants(), "src/main/resources/tenants.json");
        tenants.findLogin(login).setLogin(newLogin);
        JsonSaver.makeJson(tenants,"src/main/resources/tenants.json");
    }

    public void editEmail(){
        out.println("Wprowadź swój login");
        Tenants tenants = JsonReader.create(new Tenants(), "src/main/resources/tenants.json");
        String tenantLogin = scanner.nextLine();
        out.println("Wprowadź nowy email: ");;
        setNewEmail(tenantLogin);
    }

    public void setNewEmail(String login) {
        Tenants tenants = JsonReader.create(new Tenants(), "src/main/resources/tenants.json");
        tenants.findLogin(login).setEmail(scanner.nextLine());
        JsonSaver.makeJson(tenants,"src/main/resources/tenants.json");


    }

    public void editName(){
        out.println("Wprowadź swój login");
        Tenants tenants = JsonReader.create(new Tenants(), "src/main/resources/tenants.json");
        String tenantLogin = scanner.nextLine();
        out.println("Wprowadź nowe imię: ");;
        setNewName(tenantLogin);
    }

    public void setNewName(String login) {
        Tenants tenants = JsonReader.create(new Tenants(), "src/main/resources/tenants.json");
        tenants.findLogin(login).setName(scanner.nextLine());
        JsonSaver.makeJson(tenants,"src/main/resources/tenants.json");

    }

    public void editSurname(){
        out.println("Wprowadź swój login");
        Tenants tenants = JsonReader.create(new Tenants(), "src/main/resources/tenants.json");
        String tenantLogin = scanner.nextLine();
        out.println("Wprowadź nowe nazwisko: ");;
        setNewSurname(tenantLogin);
    }

    public void setNewSurname(String login) {
        Tenants tenants = JsonReader.create(new Tenants(), "src/main/resources/tenants.json");
        tenants.findLogin(login).setSurname(scanner.nextLine());
        JsonSaver.makeJson(tenants,"src/main/resources/tenants.json");

    }



}
