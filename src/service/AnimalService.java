import entity.Animal;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by andrewdmo on 8/19/16.
 */
public class AnimalService {

    private AnimalRepository animalRepository;

    //constructor:
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    //menu 1:
    public ArrayList<Animal> listAnimals() {
        return this.animalRepository.listAnimal();
    }

    //menu 2:
    public void createAnimal(Animal animal) throws IOException {
        animalRepository.createAnimal(animal);
    }

    //method for menu 3:
    public Animal viewAnimal(int index) {
        try {
            return animalRepository.viewAnimal(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    //method for menu 4:
    public void editAnimal(int index, Animal animal) throws IOException {
        animalRepository.editAnimal(index, animal);
    }

    //method for menu 5:
    public void deleteAnimal(int index) throws IOException {
        try {
            animalRepository.deleteAnimal(index);
        } catch (IndexOutOfBoundsException e) {

        }
    }

    public Animal getAnimal(int index) {
        try {
            return animalRepository.getAnimal(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}


//    public static String viewAnimal(int viewInput) {
//
//        //ArrayList currentList = entity.Animal.masterList;
//
//        //best math I've done in ages:
//        int indexPoint = (5 * viewInput) - 5;
//        int one = indexPoint + 1;
//        int two = indexPoint + 2;
//        int three = indexPoint + 3;
//        int four = indexPoint + 4;
//
//        // get values @ index:
//        String listIndex = String.valueOf(viewInput);
//        Object listName = currentList.get(one);
//        Object listSpecies = currentList.get(two);
//        Object listBreed = currentList.get(three);
//        Object listDescription = currentList.get(four);
//
//        return listIndex + ". " + listName + " " + listSpecies + " " + listBreed + " " + listDescription;
//    }


//    public static ArrayList editAnimal(ArrayList editedList) {
//        entity.Animal.listEditor(editedList);
//        return currentList;
//    }
//
//
//    public static boolean deleteAnimal(int deleteInput) {
//        //setup:
//        ArrayList deleteList = AnimalsService.currentList;
//        int indexPoint = deleteInput * 5 - 5;
//
//        deleteList.subList(indexPoint, indexPoint + 5).clear();
//        int newListSize = deleteList.size();
//        int v = 1;
//        for (int i = 0;
//             i < newListSize;
//             i = i + 5) {
//            deleteList.set(i, v);
//            v++;
//        }
//        entity.Animal.listEditor(deleteList);
//
//        return true;
//    }

















