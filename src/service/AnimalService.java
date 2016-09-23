package service;

import entity.*;
import repository.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by andrewdmo on 8/19/16.
 */
public class AnimalService {

    private AnimalRepository animalRepository;
    private AnimalTypeRepository animalTypeRepository;
    private MenuService menuService;


    //constructor:
    public AnimalService(AnimalRepository animalRepository, AnimalTypeRepository animalTypeRepository) throws SQLException {
        this.animalRepository = animalRepository;
        this.animalTypeRepository = animalTypeRepository;
    }

    //menu 1:
    public ArrayList<Animal> listAnimal() throws SQLException {

        ArrayList<Animal> animals = new ArrayList<>();
        try {
            ResultSet resultSet = this.animalRepository.listAnimals();

            while (resultSet.next()) {
                Animal animal = new Animal(
                    resultSet.getInt("animal_id_pk"),
                    resultSet.getString("animalname"),
                    resultSet.getInt("animaltypeid"),
                    resultSet.getString("animalbreed"),
                    resultSet.getString("animaldescription")

                    //resultSet.getString("Note")
                    //////getArray (Note!!!!)
                );
                animals.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animals;
    }


    public ArrayList<String> listAnimalTypes(AnimalTypeRepository animalTypeRepository) throws SQLException {
        ArrayList<String> animalTypes = new ArrayList<>();
        try {
            ResultSet resultSet = animalTypeRepository.listType();
            while (resultSet.next()) {
                String animalType = resultSet.getString(("animaltypename"));

                animalTypes.add(animalType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animalTypes;
    }

    public int SingleTypeIdFromName(String typeName) throws SQLException{
        return animalTypeRepository.SingleTypeIdFromName(typeName);
    }


    public boolean createAnimal(Animal newAnimal) throws SQLException {

        newAnimal = animalRepository.createAnimal(newAnimal);

        newAnimal.getIdNum();

        return true;
    }

    public Animal viewAnimal(int idNum) throws SQLException {

        return animalRepository.viewAnimal(idNum);
    }


    public Animal editAnimal(int idNum, String name, int typeId, String breed, String description) throws SQLException {

        Animal editedAnimal = new Animal(0, name, 0, breed, description);

        animalRepository.editAnimal(editedAnimal);

        return editedAnimal;
    }


    public void deleteAnimal(Animal delAnimal) throws SQLException {
        try {
            animalRepository.deleteAnimal(delAnimal);
        } catch (IndexOutOfBoundsException e) {
        }
    }


    public ArrayList<Animal> searchByType(String inputType) throws SQLException {
        ArrayList<Animal> allAnimals = listAnimal();
        ArrayList<Animal> sameTypeAnimals = new ArrayList<>();

        for (Animal a : allAnimals) {
            int typeNum = a.getTypeId();

             String type = animalTypeRepository.TypeNamesFromId(typeNum).toLowerCase();

            if (type.equals(inputType)) {
                sameTypeAnimals.add(a);
            }
        }
        return sameTypeAnimals;
    }

    public ArrayList<Animal> searchByName(String inputName) throws SQLException {
        ArrayList<Animal> allAnimals = listAnimal();
        ArrayList<Animal> sameNameAnimals = new ArrayList<>();

        for (Animal a : allAnimals) {
            String name = a.getName().toLowerCase();

            if (name.equals(inputName)) {
                sameNameAnimals.add(a);
            }
        }
        return sameNameAnimals;
    }


}

//                animalService.searchByType(typeInput);
//
//        animalTypeRepository.TypeIdFromName(inputType);
//
//
//            }


//        ArrayList<Integer> animalTypeId = new ArrayList<>();
//        try {
//            ResultSet resultSet = animalTypeRepository.TypeIdFromName(input);
//            while (resultSet.next()) {
//                int typeId = resultSet.getInt(("animaltype_pk"));
//
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return animalTypeId;
//    }
//}


//        ArrayList<Animal> animalsId = animalTypeRepository.listTypeId();
//        ArrayList<Animal> searchResult = null;
//
//        for (Animal searchAnimal : viewAnimals) {
//
//             if (searchAnimal.getTypeId() == input) {
//                 searchResult.add(searchAnimal);
//             }
//                return viewAnimals;
//        }
//        menuService.displayNoSuchAnimal();
//        return viewAnimals;


//public Animal


//    Animal placeHolder = new Animal();
//        for (Animal animal : animals(index)) {
//        if (animal.getID() == index) {
//            return animal;
//        }
//


//method for menu 3:
//    public entity.Animal viewAnimal(int index) {
//        try {
//            return animalRepository.viewAnimal(index);
//        } catch (IndexOutOfBoundsException e) {
//            return null;
//        }
//    }

//method for menu animalShelter_v1_4:
//    public void editAnimal(int index, entity.Animal animal) throws IOException {
//        animalRepository.editAnimal(index, animal);
//    }
//
//    //method for menu 5:
//    public void deleteAnimal(int index) throws IOException {
//        try {
//            animalRepository.deleteAnimal(index);
//        } catch (IndexOutOfBoundsException e) {
//
//        }
//    }

//    public entity.Animal getAnimal(int index) {
//        try {
//            return animalRepository.getAnimal(index);
//        } catch (IndexOutOfBoundsException e) {
//            return null;
//        }
//    }


//    public static String viewAnimal(int viewInput) {
//
//        //ArrayList currentList = entity.Animal.masterList;
//
//        //best math I've done in ages:
//        int indexPoint = (5 * viewInput) - 5;
//        int one = indexPoint + 1;
//        int two = indexPoint + 2;
//        int three = indexPoint + 3;
//        int four = indexPoint + animalShelter_v1_4;
//
//        // get values @ index:
//        String listIndex = String.valueOf(viewInput);
//        Object listName = currentList.get(one);
//        Object listBreed = currentList.get(three);
//        Object listDescription = currentList.get(four);
//
//        return listIndex + ". " + listName + " " + " " + listBreed + " " + listDescription;
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

















