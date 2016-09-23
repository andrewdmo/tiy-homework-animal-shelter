package service;

import entity.*;
import repository.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by andrewdmo on 8/19/16.
 */

public class MenuService {

    private AnimalService animalService;
    private AnimalTypeRepository animalTypeRepository;

    public MenuService(AnimalService animalService, AnimalTypeRepository animalTypeRepository) throws SQLException, NullPointerException {

        this.animalService = animalService;
        this.animalTypeRepository = animalTypeRepository;

        System.out.println("\n-+- Welcome to Noah's Park, human!! -+- \n | \n-+- ...we're all endangered here... -+-\n | ");

        //(default animals:)
        //entity.Animal example1 = new entity.Animal("Fido", "Dog", "Yipper", "He's a runt");
        //entity.Animal example2 = new entity.Animal("Simba", "Cat", "Scaredy", "One life left");
    }

    Scanner action = new Scanner(System.in);

    public int waitForInt(String defaultQues) {

        System.out.println("\n--+-- Mane Menewe: --+--\n" + "\n" +
            //"1) List critters\n" +
            "1) Create critter\n" +
            //      "3) View critter specifics \n" +
            "2) Manage critter\n" +
            "3) Manage critter types\n" +
            "4) Quit(ter)");

        return intToInput(defaultQues, 1, 4);
    }

    public void menuManage(String repeatQuestion) throws SQLException {

        ArrayList<Animal> animals = animalService.listAnimal();

        System.out.println("\n--+-- Corral Critter: --+--\n\n"
            + "Search Critter By:" + "\n\n" +
            "1) Critter type\n" +
            "2) Critter name\n" +
            "3) Critter num\n" +
            "4) List all critters\n" +
            "5) Quit(ter)");

        int manageInput = intToInput(":?:", 1, 5);

        if (manageInput == 1) {

            String inputType = waitForString("Type a type to search:", true).toLowerCase();

            boolean isFound = false;
            while (isFound == false) {
                for (Animal t : animals) {
                    String type = animalTypeRepository.TypeNamesFromId(t.getTypeId());
                    if (type.equalsIgnoreCase(inputType)) {
                        isFound = true;
                    } else {
                        //repeatQuestion = waitForString("Atypical type, type another:", true);
                        System.out.println("Atypical type, type another:");
                        menuManage(repeatQuestion);
                    }
                }
                break;
            }

            ArrayList<Animal> sameType = animalService.searchByType(inputType);

            for (Animal a : sameType) {
                System.out.println("ID:      |Name:      |Type");
                System.out.println(a.getIdNum() + "\t" + a.getName() + inputType);

                Animal choice = sameType.get(intToInput("Which critter (ID):?:", 1, sameType.size()));

                menuSubManage(choice.getIdNum());
            }



        } else if (manageInput == 2) {
            String inputName = waitForString("Name a name to search:", true).toLowerCase();

            ArrayList<Animal> sameName = animalService.searchByName(inputName);
            boolean isFound = false;
            while (isFound == false) {
                for (Animal t : sameName) {
                    if (t.getName().equalsIgnoreCase(t.getName())) {
                        isFound = true;
                        break;
                    }
                }
                if (isFound == false) {
                    //reshow typeList?:
                    repeatQuestion = waitForString("Namely, not present:", true);
                    menuManage(repeatQuestion);
                }

                for (Animal a : sameName) {
                    System.out.println("ID:      |Name:      |Type");
                    System.out.println(a.getIdNum() + "\t" + a.getName() + "\t" +
                        animalTypeRepository.TypeNamesFromId(a.getTypeId()));

                    Animal choice = sameName.get(intToInput("Which critter (ID):?:", 1, sameName.size()));

                    menuSubManage(choice.getIdNum());
                }
            }



        } else if (manageInput == 3) {

            int idInput = intToInput("ID an ID to search");

            boolean isFound = false;
            while (isFound == false) {
                for (Animal t :
                    animalService.listAnimal()) {
                    if (t.getIdNum() == idInput) {
                        isFound = true;
                        System.out.println("ID:      |Name:      |Type");
                        System.out.println(t.getIdNum() + "\t" + t.getName() + "\t" +
                            animalTypeRepository.TypeNamesFromId(t.getTypeId()));
                        break;
                    } else {
                        //reshow typeList?:
                        intToInput("Fake ID, try again");
                        //  menuManage(repeatQuestion);
                    }
                }
            }




        } else if (manageInput == 4)

        {
            menuList(animalService);
            int choice = intToInput("Which critter to rule them all?");
            menuSubManage(choice);

        } else if (manageInput == 5)

        {
        }
    }


    public void menuSubManage(int idNum) throws SQLException {
        waitForInt("TEST SUBMANAGE");
    }


    public int intToInput(String defaultQues, int min, int max) {

        System.out.println(defaultQues);
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();
        int inputInt;
        try {
            inputInt = Integer.parseInt(userInput);
            //return inputInt;
            if (inputInt > max || inputInt < min) {
                return intToInput("Noah pities the fool!...number in range:", min, max);
            }
            {
                return inputInt;
            }
        } catch (Exception e) {
            return intToInput("Noah pities fools that can't tell letters from numbers!!...try again, Darwin:");
            // return inputInt;
        }
        //return inputInt;
    }

    public int intToInput(String message) {

        System.out.println(message);
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();

        int inputInt;
        try {
            inputInt = Integer.parseInt(userInput);
        } catch (Exception e) {
            return intToInput("Noah pities fools that can't tell letters from numbers!!...try again, Darwin:");
        }
        return inputInt;
    }


    private String waitForString(String message, boolean required) {
        System.out.println(message);
        String input = action.nextLine();

        if (required && input.trim().length() == 0) {
            System.out.println("\nSay somethin'!:\n");

            input = waitForString(message, required);
        }
        return input.trim();
    }

    private String waitForString(String message, String defaultInput) {
        String input = waitForString(message, false);

        if (input.isEmpty()) {
            return defaultInput;
        } else {
            return input;
        }
    }

    public void menuList(AnimalService animalService) throws SQLException {
//        this.animalService = animalService;

        System.out.println("\n-+- Critters aboard: -+-\n");

        ArrayList<Animal> animals = animalService.listAnimal();
        //  System.out.println(animals);
        if (animals.size() == 0) {
            System.out.println("Ark's empty!  Go trap something.");
        } else {
            for (int x = 0; x < animals.size(); x++) {

                Animal animal = animals.get(x);
                System.out.println("ID:      |Name:      |Type");
                System.out.println(animal.getIdNum() + "\t" + animal.getName() + "\t" + animal.getTypeId());
//                System.out.printf("%s %s %s\n", (x + 1) + ".", animal.getName(), animal.getTypeId());
            }
        }
    }

    public Animal menuCreate(AnimalService animalService, AnimalTypeRepository animalTypeRepository) throws
        SQLException {
        ArrayList<String> currentTypes = animalService.listAnimalTypes(animalTypeRepository);

        String typeList = String.format("Critter Type %s:?:", currentTypes);
        System.out.println("-+- Create Critter -+-\n");
        String name = waitForString("Critter Name:?: ", true);
        String type = waitForString(typeList, true);
        boolean isFound = false;
        while (isFound == false) {
            for (String t : currentTypes) {
                if (type.equalsIgnoreCase(t)) {
                    isFound = true;
                    break;
                }
            }
            if (isFound == false) {
                //reshow typeList?:
                type = waitForString("Atypical type, type another:", true);
            }
        }

        String breed = waitForString("Critter breed:?: ", true);
        String details = waitForString("Critter description (optional):?: ", "[Empty]");

        ////////needs to be Array SQL:
        //String notes = waitForString("Critter Note (optional):?:", null);

        Animal newAnimal = new Animal(name, animalTypeRepository.SingleTypeIdFromName(type), breed, details); //Note

        if (animalService.createAnimal(newAnimal)) {
            System.out.printf("Congrats, %s has been begat!\n", name);
            return newAnimal;

        } else {
            System.out.printf("Nature F'd up and %s was not begat", name);
            menuCreate(animalService, animalTypeRepository);
            return null;
            //return new entity.Animal(name, breed, details);
        }
    }

    public void menuViewDetails(AnimalService animalService) throws SQLException {

        ArrayList<Animal> viewAnimals = animalService.listAnimal();

        System.out.printf("-+- View Critter Specifics -+-\n\n");
        int userInput = intToInput("View which critter up close:?:", 1, viewAnimals.size());

        Animal viewAnimal = viewAnimals.get(userInput - 1);

        System.out.printf(
            "\nBehold, critter %s!!\n\n" +
                //"Name: %s\n" +
                "ID Num: %s\n" +
                "Type: %s\n" +
                "Breed: %s\n" +
                "Description: %s\n",

            //viewAnimal.getidNum();
            viewAnimal.getName(),
            viewAnimal.getIdNum(),
            viewAnimal.getTypeId(),
            viewAnimal.getBreed(),
            viewAnimal.getDescription());
    }

    public Animal menuEdit(AnimalService animalService) throws SQLException {
        System.out.println("-+- Splice Critter's Genes -+-");


        ArrayList<Animal> editAnimals = animalService.listAnimal();

        int userInput = intToInput("Cut up which critter:?:", 1, editAnimals.size());

        Animal editAnimal = editAnimals.get(userInput - 1);

        System.out.println("\nNew values for... " + editAnimal.getName() + " ('enter' for current):?:");

        String name = waitForString(
            String.format("Name [%s]:?: ", editAnimal.getName()),
            editAnimal.getName());
        String typeId = waitForString(
            String.format("Type [%s]:?: ", "type"), "type");
        //editAnimal.getTypeId());
        String breed = waitForString(
            String.format("Breed [%s]:?: ", editAnimal.getBreed()),
            editAnimal.getBreed());
        String description = waitForString(
            String.format("Specifics [%s]:?:", editAnimal.getDescription()), editAnimal.getDescription());

        Animal editedAnimal = animalService.editAnimal(0, name, 0, breed, description); //Note

        if (editedAnimal != null) {
            System.out.printf("\nCongrats, %s has been horribly altered!\n", editedAnimal.getName());
            return editedAnimal;

        } else {
            System.out.printf("Nature F'd up and %s was not begat", name);
            menuEdit(animalService);
            return null;
        }
    }

    public void menuDelete(AnimalService animalService) throws SQLException {

        System.out.println("\n-+- Decease Critter -+-\n");

        ArrayList<Animal> viewAnimals = animalService.listAnimal();

        int delInput = intToInput("Animal number (from List):?:", 1, viewAnimals.size());

        Animal delAnimal = viewAnimals.get(delInput - 1);

        animalService.deleteAnimal(delAnimal);

        System.out.println("Congrats Lord Homo, " + "'" + delAnimal.getName() + "' is now extinct.  One less bowl to fill!");

    }

    public void menuCreateNote(int animalId) throws SQLException {

        System.out.println("\n-+- Wrote a note? -+-\n");
        NoteService noteService = new NoteService();
        noteService.createNote(animalId, waitForString("", true));

    }

    public void menuDeleteNote(int animalId) throws SQLException, IOException {

        System.out.println("\n-+- Float a note down the moat? -+-\n");
        NoteService noteService = new NoteService();
        noteService.deleteNote(animalId);
    }

    public void displayNoSuchAnimal() {
        System.out.println("\nThat animal's either already et or otherwise dispatched.\n");

    }
}

//if (animalList.size() == 0) {
//    System.out.println("\nArk's empty!  Go trap something.\n");
//    } else {
//    for (int x = 0; x < animalList.size(); x++) {
//    entity.Animal animal = animalList.get(x);
//    System.out.printf("%s) %s\n", (x + 1) + ".", animal.getName() + "\n", x);
//    }
//    }