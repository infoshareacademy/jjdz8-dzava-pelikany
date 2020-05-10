package dzavaPelikany.service;


import dzavaPelikany.domain.Owners;
import dzavaPelikany.fileOperation.JsonReader;
import dzavaPelikany.fileOperation.JsonSaver;

import java.io.IOException;
import java.util.Scanner;


import static dzavaPelikany.fileOperation.FilesNames.OWNERS_JSON;
import static java.lang.System.in;
import static java.lang.System.out;

public class OwnerEditService {

   Scanner scanner = new Scanner(in);


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

   }

   public void setNewLogin (String login, String newLogin) throws IOException {
      Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
      owners.findLogin(login).setLogin(newLogin);
      JsonSaver.makeJson(owners,OWNERS_JSON);
   }

   public void editEmail() throws IOException, InterruptedException {
      out.println("Wprowadź swój login");
      String OwnerLogin = scanner.nextLine();
      out.println("Wprowadź nowy email: ");
      setNewEmail(OwnerLogin);

   }

   public void setNewEmail(String login) throws IOException {
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

   }

   public void setNewName(String login) throws IOException {
      Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
      owners.findLogin(login).setName(scanner.nextLine());
      JsonSaver.makeJson(owners,OWNERS_JSON);

   }

   public void editSurname() throws IOException, InterruptedException {
      out.println("Wprowadź swój login");
      String tenantLogin = scanner.nextLine();
      out.println("Wprowadź nowe nazwisko: ");;
      setNewSurname(tenantLogin);

   }

   public void setNewSurname(String login) throws IOException {
      Owners owners = JsonReader.create(new Owners(), OWNERS_JSON);
      owners.findLogin(login).setSurname(scanner.nextLine());
      JsonSaver.makeJson(owners,OWNERS_JSON);

   }

}
