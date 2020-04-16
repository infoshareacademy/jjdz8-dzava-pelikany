package com.infoshareacademy.view;

import static java.lang.System.*;

public interface Screen {


    String LINE = "-----------------------------------------------------";
    String LOGIN_1 = "1. Login";
    String NAME_2 = "2. Imię";
    String SURNAME_3 = "3. Nazwisko";
    String EMAIL_4 = "4. Email";

    String WRONG_ANSWER = "Nieprawidłowa wartość spróbuj ponownie.";

    static void clearScreen() {
        out.println();
        out.println();
        out.println();
        out.println();
    }

    static void editData(){
        out.println("Wybierz, co chcesz edytować: ");
        out.println(LOGIN_1);
        out.println(NAME_2);
        out.println(SURNAME_3);
        out.println(EMAIL_4);
        out.println("\n\n0. Powrót do menu");
    }



}
