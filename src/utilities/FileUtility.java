package utilities;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import model.Plant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtility {
    public static Plant[] readFromFile(String filename) throws IOException {
        Gson gson = new Gson();
        Plant[] plants = null;
        try {
            Path path = Paths.get(filename);
            plants = gson.fromJson(Files.readString(path), Plant[].class);
        } catch (FileNotFoundException e) {
            throw new IOException("file_nonexistent");
        } catch (IOException e) {
            throw new IOException("reading_unsuccessful");
        } catch (JsonSyntaxException e) {
            throw new IOException("not_valid_json");
        }
        return plants;
    }
    public static void writeToFile(Plant[] plants, String filename) throws IOException {
        Gson gson = new Gson();
        try {
            Path path = Paths.get(filename);
            String plantsStr = gson.toJson(plants);
            Files.write(path, plantsStr.getBytes());
        } catch (FileNotFoundException ex) {
            throw new IOException("file_nonexistent");
        } catch (IOException e) {
            throw new IOException("writing_unsuccessful");
        }
    }
}