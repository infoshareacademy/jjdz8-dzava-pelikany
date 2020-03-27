package com.infoshareacademy.Utilities;

import com.infoshareacademy.View.TenantScreen;

import org.json.simple.*;
import org.json.simple.parser.*;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class RoomSearch {
    public void setCriteria() throws IOException {
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

    public void printRoomsAvailableByPriceAndOrCity(boolean price, boolean city) throws IOException {
        JSONParser jsonParser = new JSONParser();
        double priceMax = 0;
        String citySelected = null;

        if (price) {
            Scanner priceScanner = new Scanner(System.in);
            System.out.println("Podaj maksymalną cenę za pokój: ");
            priceMax = priceScanner.nextDouble();
        }
        if (city) {
            Scanner cityScanner = new Scanner(System.in);
            System.out.println("W jakim mieście szukać pokoju?");
            citySelected = cityScanner.nextLine();
        }
        try {
            FileReader fileReader = new FileReader("src/main/resources/rooms.json");
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println();
            int i = 1;
            JSONArray roomList = (JSONArray) jsonObject.get("roomsList");
            for (JSONObject object : (Iterable<JSONObject>) roomList) {
                String priceString = (String) object.get("price");
                String statusString = (String) object.get("status");
                String cityFromJSON = (String) object.get("city");
                if (city && price) {
                    if (priceMax > Double.parseDouble(priceString) && cityFromJSON.contentEquals(citySelected) && !Boolean.parseBoolean(statusString)) {
                        printRoomDetails((String)object.get("address"), (String)object.get("price"), i);
                    }
                } else if (city) {
                    if (cityFromJSON.contentEquals(citySelected) && !Boolean.parseBoolean(statusString)) {
                        printRoomDetails((String)object.get("address"), (String)object.get("price"), i);
                    }
                } else if (price) {
                    if (priceMax > Double.parseDouble(priceString) && !Boolean.parseBoolean(statusString)) {
                        printRoomDetails((String)object.get("address"), (String)object.get("price"), i);
                    }
                }
            i++;
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


    public void printRoomDetails(String address, String price, Integer iterator) {
        System.out.println(iterator + ". Adres: " + address + "\n\tCena: " + price);
    }
}