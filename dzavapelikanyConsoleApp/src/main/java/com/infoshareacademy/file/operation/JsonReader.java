package com.infoshareacademy.file.operation;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;

import static java.lang.System.*;


public class JsonReader {

    public static <T> T create(T object, String fileName) {
        if (dontExist(fileName)) {
            return object;
        } else {
            Gson gson = new Gson();
            try {
                object = gson.fromJson(new FileReader(fileName), (Type) object.getClass());

            } catch (Exception e) {
                out.println("Coś poszło nie tak?!?!" + e.getMessage());
            }
        }
        return object;
    }

    public static boolean dontExist(String fileName) {
        File file = new File(fileName);

        return !file.exists() || file.length() == 0;
    }
}
