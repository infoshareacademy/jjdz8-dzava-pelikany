package com.infoshareacademy.utilities;

import java.util.Scanner;

class InputCheck {

    public static final Scanner scanner = new Scanner(System.in);

    public static boolean emailRegex(String email) {
        return !email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
    }

    public static boolean nameRegex(String name) {
        return !name.matches("^[a-zA-Z\\s]+");
    }

    public static boolean surnameRegex(String surname) {
        return !surname.matches("^[a-zA-Z\\s]+");
    }

    public static boolean cityRegex(String city) {
        return !city.matches("^[a-zA-Z\\s]+");
    }
}
