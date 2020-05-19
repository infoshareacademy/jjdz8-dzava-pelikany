package dzavaPelikany.fileOperation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static java.lang.System.*;

public class JsonSaver {

    public static <T> void makeJson(T object, String filename) {
        try (Writer writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(object, writer);
        } catch (IOException e) {
            out.println(e.getMessage());
        }
    }
}