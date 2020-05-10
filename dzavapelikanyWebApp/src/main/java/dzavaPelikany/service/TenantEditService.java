package dzavaPelikany.service;


import dzavaPelikany.domain.Tenants;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;

import java.io.IOException;
import java.util.Scanner;

import static dzavaPelikany.fileOperation.FilesNames.TENANTS_JSON;
import static java.lang.System.in;
import static java.lang.System.out;

public class TenantEditService {

    Scanner scanner = new Scanner(in);

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

    }

    public void setNewLogin (String login, String newLogin) throws IOException {
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

    }

    public void setNewEmail(String login) throws IOException {
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

    }

    public void setNewName(String login) throws IOException {
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

    }

    public void setNewSurname(String login) throws IOException {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        tenants.findLogin(login).setSurname(scanner.nextLine());
        JsonSaver.makeJson(tenants,TENANTS_JSON);

    }



}
