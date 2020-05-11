package dzavaPelikany.fileOperation;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;


public class JsonReader {

    public static <T> T create(T object, String fileName) {
        if (dontExist(fileName)) {
            return object;
        } else {
            Gson gson = new Gson();

            try {
                object = gson.fromJson(new FileReader(fileName), (Type) object.getClass());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        return object;
    }

    public static boolean dontExist(String fileName) {
        File file = new File(fileName);

        return !file.exists() || file.length() == 0;
    }
}
