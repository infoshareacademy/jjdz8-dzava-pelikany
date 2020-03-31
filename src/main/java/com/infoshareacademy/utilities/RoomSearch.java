package com.infoshareacademy.utilities;

import com.infoshareacademy.view.TenantScreen;

import org.json.simple.*;
import org.json.simple.parser.*;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RoomSearch {
  public void setCriteria() throws IOException, InterruptedException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Według jakich kryteriów chciałbyś wyszukać pokój:");
    System.out.println("1. Cena");
    System.out.println("2. Miasto");
    System.out.println("3. Cena i Miasto");
    System.out.println("0. Powrót");
    switch (scanner.nextByte()) {
      case 1:
        printRoomsAvailableByPriceAndOrCity(true, false);
        break;
      case 2:
        printRoomsAvailableByPriceAndOrCity(false, true);
        break;
      case 3:
        printRoomsAvailableByPriceAndOrCity(true, true);
        break;
      case 0:
        new TenantScreen().tenantMenu();
        break;
    }
  }

  public void printRoomsAvailableByPriceAndOrCity(boolean price, boolean city) throws IOException, InterruptedException {
    JSONParser jsonParser = new JSONParser();
    double priceMax = 0;
    double priceMin = 0;
    String citySelected = null;
    if (price) {
      Scanner priceScannerMin = new Scanner(System.in);
      System.out.println("Podaj minimalną cenę za pokój: ");
      priceMin = priceScannerMin.nextDouble();
    }

    if (price) {
      Scanner priceScannerMax = new Scanner(System.in);
      System.out.println("Podaj maksymalną cenę za pokój: ");
      priceMax = priceScannerMax.nextDouble();
    }
    if (city) {
      Scanner cityScanner = new Scanner(System.in);
      System.out.println("W jakim mieście szukać pokoju?");
      citySelected = convertCityName(cityScanner.nextLine());
    }
    try {
      FileReader fileReader = new FileReader("src/main/resources/rooms.json");
      Object obj = jsonParser.parse(fileReader);
      JSONObject jsonObject = (JSONObject) obj;
      System.out.println();
      int iterator = 0;
      JSONArray roomList = (JSONArray) jsonObject.get("roomsList");
      for (JSONObject object : (Iterable<JSONObject>) roomList) {
        Double priceFromFile = (double) object.get("price");
        boolean status = (boolean) object.get("status");
        String cityFromJSON = convertCityName((String) object.get("city"));
        if (city && price) {
          if (priceMin < priceFromFile && priceMax > priceFromFile && cityFromJSON.contentEquals(citySelected) && !status) {
            printRoomDetails((String)object.get("streetAndNumber"), (double)object.get("price"), ++iterator);
          }
        } else if (city) {
          if (cityFromJSON.contentEquals(citySelected) && !status) {
            printRoomDetails((String)object.get("streetAndNumber"), (double)object.get("price"), ++iterator);
          }
        } else if (price) {
          if (priceMin < priceFromFile && priceMax > priceFromFile && !status) {
            printRoomDetails((String)object.get("streetAndNumber"), (double)object.get("price"), ++iterator);
          }
        }
      }
      Scanner scanner = new Scanner(System.in);
      scanner.nextLine();

    } catch (FileNotFoundException e) {
      System.out.println("Coś poszło nie tak.");
    } catch (IOException | ParseException e) {
      System.out.println("Coś innego");
    }
    TenantScreen tenantScreen = new TenantScreen();
    tenantScreen.tenantMenu();
  }


  public void printRoomDetails(String address, double price, Integer iterator) {
    System.out.println(iterator + ". Adres: " + address + "\n\tCena: " + price);
  }

  public String convertCityName(String cityName) {
    String convertedCityName = cityName.toLowerCase();
    return convertedCityName.replace("ą","a").replace("ć","c").replace("ę","e").replace("ł","l").replace("ń","n").replace("ó","o").replace("ś","s").replace("ż","z").replace("ź","z");
  }
}