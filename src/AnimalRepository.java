import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewdmo on 9/8/16.
 */
public class AnimalRepository {

    private final Path filePath;
    private final Gson gson;

    ArrayList<Animal> animalsList = new ArrayList<>();

    //constructor:
    public AnimalRepository(String file) throws IOException {
        gson = new GsonBuilder().setPrettyPrinting().create();

        filePath = Paths.get(file);

        if (Files.exists(filePath)) {
            String json = new String(Files.readAllBytes(filePath));
            Type listType = new TypeToken<ArrayList<Animal>>() {
            }.getType();

            animalsList = gson.fromJson(json, listType);
        }
    }

    //persist('save'):
    private void persist() throws IOException {
        String json = gson.toJson(animalsList);
        Files.write(filePath, json.getBytes());
    }

    //method 1:
    public List<Animal> listAnimal() {
        return animalsList;
    }

    //Menu 2:
    public void createAnimal(Animal animal) throws IOException {
        animalsList.add(animal);

        persist();
    }


    //menu 3:
    public Animal viewAnimal(int index) {
        return animalsList.get(index);
    }

    //menu 4:
    public void editAnimal(int index, Animal animal) throws IOException {
        animalsList.set(index, animal);

        persist();
    }

    //menu 5:
    public void deleteAnimal(int index) throws IOException {
        animalsList.remove(index);

        persist();
    }

    public Animal getAnimal(int index) {
        return animalsList.get(index);
    }
}