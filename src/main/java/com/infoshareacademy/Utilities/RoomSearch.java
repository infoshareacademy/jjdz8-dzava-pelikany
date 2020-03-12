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
        switch (scanner.nextByte()){
            case 1:
                printRoomsAvailableByPrice();
                break;
            case 2:
                printRoomsAvailableByCity();
                break;
            case 3:
                printRoomsAvailableByPriceAndCity();
                break;
            case 0:
                new TenantScreen().tenantMenu();
                break;
        }
    }
    public void printRoomsAvailableByPrice() throws IOException {
        JSONParser jsonParser = new JSONParser();
        Scanner priceScanner = new Scanner(System.in);
        System.out.println("Podaj maksymalną cenę za pokój: ");
        double priceMax = priceScanner.nextDouble();


        try {
            FileReader fileReader = new FileReader("src/main/resources/rooms.json");
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println();
            int i = 1;
            JSONArray roomList = (JSONArray) jsonObject.get("roomsList");
            for (JSONObject object : (Iterable<JSONObject>) roomList) {
            String priceString = (String)object.get("price");
            String statusString = (String)object.get("status");

                if (priceMax > Double.parseDouble(priceString) && !Boolean.parseBoolean(statusString)) {
                    System.out.println(i + ". Adres: " + object.get("address") + "\n\tCena: " + object.get("price"));
                    i++;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Coś poszło nie tak.");
        } catch (IOException | ParseException e){
            System.out.println("Coś innego");
        }
        new TenantScreen().tenantMenu();


    }
    public void printRoomsAvailableByCity() throws IOException {
        JSONParser jsonParser = new JSONParser();
        Scanner cityScanner = new Scanner(System.in);
        System.out.println("W jakim mieście szukać pokoju?");
        String citySelected = cityScanner.nextLine();


        try {
            FileReader fileReader = new FileReader("src/main/resources/rooms.json");
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println();
            int i = 1;
            JSONArray roomList = (JSONArray) jsonObject.get("roomsList");
            for (JSONObject object : (Iterable<JSONObject>) roomList) {
                String city = (String)object.get("city");
                String statusString = (String)object.get("status");

                if (city.contentEquals(citySelected) && !Boolean.parseBoolean(statusString)) {
                    System.out.println(i + ". Adres: " + object.get("address") + "\n\tCena: " + object.get("price"));
                    i++;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Coś poszło nie tak.");
        } catch (IOException | ParseException e){
            System.out.println("Coś innego");
        }
        new TenantScreen().tenantMenu();




    }
    public void printRoomsAvailableByPriceAndCity() throws IOException {
        JSONParser jsonParser = new JSONParser();
        Scanner priceScanner = new Scanner(System.in);
        System.out.println("Podaj maksymalną cenę za pokój: ");
        double priceMax = priceScanner.nextDouble();
        Scanner cityScanner = new Scanner(System.in);
        System.out.println("W jakim mieście szukać pokoju?");
        String citySelected = cityScanner.nextLine();

        try {
            FileReader fileReader = new FileReader("src/main/resources/rooms.json");
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println();
            int i = 1;
            JSONArray roomList = (JSONArray) jsonObject.get("roomsList");
            for (JSONObject object : (Iterable<JSONObject>) roomList) {
                String priceString = (String)object.get("price");
                String statusString = (String)object.get("status");
                String city = (String)object.get("city");

                if (priceMax > Double.parseDouble(priceString) && city.contentEquals(citySelected) && !Boolean.parseBoolean(statusString)) {
                    System.out.println(i + ". Adres: " + object.get("address") + "\n\tCena: " + object.get("price"));
                    i++;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Coś poszło nie tak.");
        } catch (IOException | ParseException e){
            System.out.println("Coś innego");
        }
        new TenantScreen().tenantMenu();


    }






}