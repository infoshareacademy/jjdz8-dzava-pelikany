package com.infoshareacademy.utilities;

import com.infoshareacademy.domain.entity.Tenant;
import com.infoshareacademy.domain.entity.Tenants;
import com.infoshareacademy.file.operation.JsonReader;
import com.infoshareacademy.file.operation.JsonSaver;

import java.util.Scanner;

import static com.infoshareacademy.file.operation.FilesNames.TENANTS_JSON;
import static java.lang.System.*;

public class TenantAccountCreator extends InputCheck {

    Scanner scanner = new Scanner(in);

    private Tenant makeTenant() {
        String login = getCorrectTenantLogin();
        out.println("Wprowadź imię: ");
        String name = scanner.nextLine();
        while (InputCheck.nameRegex(name)) {
            out.println("Niepoprawne dane. Spróbuj ponownie: ");
            name=scanner.nextLine();
        }
        out.println("Wprowadź nazwisko: ");
        String surname = scanner.nextLine();
        while (InputCheck.surnameRegex(surname)) {
            out.println("Niepoprawne dane. Spróbuj ponownie: ");
            surname=scanner.nextLine();
        }
        out.println("Wprowadź email: ");
        String email = scanner.nextLine();
        while (InputCheck.emailRegex(email)) {
            out.println("Twój mail jest niepoprawny, spróbuj jeszcze raz:");
            email=scanner.nextLine();
        }
        Tenant tenant;
        tenant = new Tenant(login);
        tenant.setName(name);
        tenant.setSurname(surname);
        tenant.setEmail(email);
        return tenant;
    }

    private void saveTenant(Tenant tenant) {
        Tenants tenants = JsonReader.create(new Tenants(), TENANTS_JSON);
        tenants.addTenant(tenant);
        JsonSaver.makeJson(tenants, TENANTS_JSON);
    }

    public void makeTenantAccount() {
        Tenant tenant = makeTenant();
        saveTenant(tenant);
        out.println("\nTwoje dane zostałe zapisane!");
    }

    private String getCorrectTenantLogin() {
        out.println("Wprowadź login: ");
        String login = scanner.nextLine();
        while (Tenants.tenantExist(login)) {
            out.println("Podany login już istnieje, spróbuj ponownie: ");
            login = scanner.nextLine();
        }

        return login;
    }
}
