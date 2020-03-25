package com.infoshareacademy.Utilities;

import com.infoshareacademy.Entity.Owners;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class OwnerEdit {

   Scanner scanner = new Scanner(in);

   public void editOwnerLogin() {
      out.println("Wprowadź dotychczasowy login: ");
      String login = scanner.nextLine();
      out.println("Wprowadź nowy login: ");
      String newLogin = scanner.nextLine();
      setNewLogin(login,newLogin);
      out.println("Dane zostały zmienione!");
   }

   public void setNewLogin (String login, String newLogin){
      Owners owners = JsonReader.create(new Owners(), "src/main/resources/owners.json");
      owners.findLogin(login).setLogin(newLogin);
      JsonSaver.makeJson(owners,"src/main/resources/owners.json");
   }

   public void editEmail(){
      out.println("Wprowadź swój login");
      Owners owners = JsonReader.create(new Owners(), "src/main/resources/owners.json");
      String OwnerLogin = scanner.nextLine();
      out.println("Wprowadź nowy email: ");;
      setNewEmail(OwnerLogin);
   }

   public void setNewEmail(String login) {
      Owners owners = JsonReader.create(new Owners(), "src/main/resources/owners.json");
      owners.findLogin(login).setEmail(scanner.nextLine());
      JsonSaver.makeJson(owners,"src/main/resources/owners.json");


   }

   public void editName(){
      out.println("Wprowadź swój login");
      Owners owners = JsonReader.create(new Owners(), "src/main/resources/owners.json");
      String tenantLogin = scanner.nextLine();
      out.println("Wprowadź nowe imię: ");;
      setNewName(tenantLogin);
      out.println("\n\n\n\nTwoje dane zostaną zapisane po ponownym uruchomieniu aplikacji!!");
   }

   public void setNewName(String login) {
      Owners owners = JsonReader.create(new Owners(), "src/main/resources/owners.json");
      owners.findLogin(login).setName(scanner.nextLine());
      JsonSaver.makeJson(owners,"src/main/resources/owners.json");

   }

   public void editSurname(){
      out.println("Wprowadź swój login");
      Owners owners = JsonReader.create(new Owners(), "src/main/resources/owners.json");
      String tenantLogin = scanner.nextLine();
      out.println("Wprowadź nowe nazwisko: ");;
      setNewSurname(tenantLogin);
   }

   public void setNewSurname(String login) {
      Owners owners = JsonReader.create(new Owners(), "src/main/resources/owners.json");
      owners.findLogin(login).setSurname(scanner.nextLine());
      JsonSaver.makeJson(owners,"src/main/resources/owners.json");

   }

}
