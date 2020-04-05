package com.infoshareacademy.utilities;

import com.infoshareacademy.entity.Owners;
import com.infoshareacademy.file.operation.JsonReader;
import com.infoshareacademy.file.operation.JsonSaver;
import com.infoshareacademy.view.OwnerScreen;

import java.io.IOException;
import java.util.Scanner;

import static com.infoshareacademy.file.operation.FilesNames.OWNERS_JSON;
import static java.lang.System.*;

public class OwnerEdit {

   Scanner scanner = new Scanner(in);
   OwnerScreen ownerScreen = new OwnerScreen();

   public void editOwnerLogin() throws IOException, InterruptedException {
      out.println("Wprowadź dotychczasowy login: ");
      String login = scanner.nextLine();
      while (!Owners.ownerExist(login)) {
         out.println("Podany login nie istnieje. Spróbuj ponownie: ");
         login = scanner.nextLine();
      }
      out.println("Wprowadź nowy login: ");
      String newLogin = scanner.nextLine();
      setNewLogin(login,newLogin);
      out.println("Dane zostały zmienione!");
      ownerScreen.ownerMenu();
   }

   public void setNewLogin (String login, String newLogin){
      Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
      owners.findLogin(login).setLogin(newLogin);
      JsonSaver.makeJson(owners,OWNERS_JSON);
   }

   public void editEmail() throws IOException, InterruptedException {
      out.println("Wprowadź swój login");
      String OwnerLogin = scanner.nextLine();
      out.println("Wprowadź nowy email: ");
      setNewEmail(OwnerLogin);
      ownerScreen.ownerMenu();
   }

   public void setNewEmail(String login) {
      Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
      owners.findLogin(login).setEmail(scanner.nextLine());
      JsonSaver.makeJson(owners,OWNERS_JSON);


   }

   public void editName() throws IOException, InterruptedException {
      out.println("Wprowadź swój login");
      String ownerLogin = scanner.nextLine();
      out.println("Wprowadź nowe imię: ");
      setNewName(ownerLogin);
      out.println("\n\n\n\nTwoje dane zostaną zapisane po ponownym uruchomieniu aplikacji!!");
      ownerScreen.ownerMenu();
   }

   public void setNewName(String login) {
      Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
      owners.findLogin(login).setName(scanner.nextLine());
      JsonSaver.makeJson(owners,OWNERS_JSON);

   }

   public void editSurname() throws IOException, InterruptedException {
      out.println("Wprowadź swój login");
      String tenantLogin = scanner.nextLine();
      out.println("Wprowadź nowe nazwisko: ");;
      setNewSurname(tenantLogin);
      ownerScreen.ownerMenu();
   }

   public void setNewSurname(String login) {
      Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
      owners.findLogin(login).setSurname(scanner.nextLine());
      JsonSaver.makeJson(owners,OWNERS_JSON);

   }

}
