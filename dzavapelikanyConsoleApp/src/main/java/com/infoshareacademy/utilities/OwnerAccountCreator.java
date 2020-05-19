package com.infoshareacademy.utilities;

import com.infoshareacademy.domain.entity.Owner;
import com.infoshareacademy.domain.entity.Owners;
import com.infoshareacademy.file.operation.JsonReader;
import com.infoshareacademy.file.operation.JsonSaver;

import java.util.Scanner;

import static com.infoshareacademy.file.operation.FilesNames.OWNERS_JSON;
import static java.lang.System.*;

public class OwnerAccountCreator extends InputCheck {

    Scanner scanner = new Scanner(System.in);

    private Owner makeOwner() {
        String login = getCorrectOwnerLogin();
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
        Owner owner;
        owner = new Owner(login);
        owner.setName(name);
        owner.setSurname(surname);
        owner.setEmail(email);
        return owner;
    }

    private void saveOwner(Owner owner) {
        Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
        owners.addOwner(owner);
        JsonSaver.makeJson(owners, OWNERS_JSON);
    }

    public void makeOwnerAccount() {
        Owner owner = makeOwner();
        saveOwner(owner);
        out.println("\nTwoje dane zostałe zapisane!");
    }

    private String getCorrectOwnerLogin() {
        out.println("Wprowadź login: ");
        String login = scanner.nextLine();
        while (Owners.ownerExist(login)) {
            out.println("Podany login już istnieje, spróbuj ponownie: ");
            login = scanner.nextLine();
        }

        return login;
    }
}
