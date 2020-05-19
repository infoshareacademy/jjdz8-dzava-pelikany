package com.infoshareacademy.utilities;

import com.infoshareacademy.domain.entity.Tenants;
import com.infoshareacademy.file.operation.JsonReader;
import com.infoshareacademy.file.operation.JsonSaver;
import com.infoshareacademy.view.TenantScreen;

import java.io.IOException;
import java.util.Scanner;

import static com.infoshareacademy.file.operation.FilesNames.TENANTS_JSON;
import static java.lang.System.*;

public class TenantEdit {

    Scanner scanner = new Scanner(in);
    TenantScreen tenantScreen = new TenantScreen();
    static final String ENTER_LOGIN = "Wprowadź swój login: ";

    public void editTenantLogin() throws IOException, InterruptedException {
        out.println("Wprowadź dotychczasowy login: ");
        String login = scanner.nextLine();
        while (!Tenants.tenantExist(login)) {
            out.println("Podany login nie istnieje. Spróbuj ponownie: ");
            login = scanner.nextLine();
        }
        out.println("Wprowadź nowy login: ");
        String newLogin = scanner.nextLine();
        setNewLogin(login,newLogin);
        out.println("Dane zostały zmienione!");
        tenantScreen.tenantMenu();
    }

    public void setNewLogin (String login, String newLogin){
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        tenants.findLogin(login).setLogin(newLogin);
        JsonSaver.makeJson(tenants,TENANTS_JSON);
    }

    public void editEmail() throws IOException, InterruptedException {
        out.println(ENTER_LOGIN);
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        String tenantLogin = scanner.nextLine();
        out.println("Wprowadź nowy email: ");
        setNewEmail(tenantLogin);
        tenantScreen.tenantMenu();
    }

    public void setNewEmail(String login) {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        tenants.findLogin(login).setEmail(scanner.nextLine());
        JsonSaver.makeJson(tenants,TENANTS_JSON);


    }

    public void editName() throws IOException, InterruptedException {
        out.println(ENTER_LOGIN);
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        String tenantLogin = scanner.nextLine();
        out.println("Wprowadź nowe imię: ");
        setNewName(tenantLogin);
        tenantScreen.tenantMenu();
    }

    public void setNewName(String login) {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        tenants.findLogin(login).setName(scanner.nextLine());
        JsonSaver.makeJson(tenants,TENANTS_JSON);

    }

    public void editSurname() throws IOException, InterruptedException {
        out.println(ENTER_LOGIN);
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        String tenantLogin = scanner.nextLine();
        out.println("Wprowadź nowe nazwisko: ");
        setNewSurname(tenantLogin);
        tenantScreen.tenantMenu();
    }

    public void setNewSurname(String login) {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        tenants.findLogin(login).setSurname(scanner.nextLine());
        JsonSaver.makeJson(tenants,TENANTS_JSON);

    }



}
