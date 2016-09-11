//package Animal;
//import entity.Animal;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andrewdmo on 8/19/16.
 */

public class MenuService {
    //AnimalService animalService = new AnimalService();
    // int max = new AnimalService;

    //AnimalService animalService;
    //AnimalService animalService;



    public MenuService(AnimalService animalService) {
        int length = animalService.listAnimal().size();
        this.length = length;

        //this.animalService = new AnimalService();

        System.out.println("\n-+- Welcome to Noah's Park, human!! -+- \n | \n-+- ...we're all endangered here... -+-\n | ");

        //(default animals:)
        Animal example1 = new Animal("Fido", "Dog", "Yipper", "He's a runt");
        Animal example2 = new Animal("Simba", "Cat", "Scaredy", "One life left");
    }

    MenuService menuService;
    static int length = MenuService.length;


    Scanner action = new Scanner(System.in);

    //   AnimalService animalService;

    public int waitForInt(String defaultQues) {

        System.out.println("\n--+-- Mane Menewe: --+--\n" + "\n" +
            "1) List critters\n" +
            "2) Create critter\n" +
            "3) View critter specifics \n" +
            "4) Edit critter\n" +
            "5) Delete critter\n" +
            "6) Quit(ter)");

        return intToInput(defaultQues, 1, 6);
    }

    public int intToInput(String defaultQues, int min, int max) {

        System.out.println(defaultQues);
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();
        int inputInt;

        try {
            inputInt = Integer.parseInt(userInput);

            if (inputInt > max || inputInt < min) {
                return intToInput("Noah pities the fool!...number in range:");
            }
        } catch (Exception e) {
            return intToInput("Noah pities fools that can't tell letters from numbers!!...try again, Darwin:");
        }
        return inputInt;
    }

    public int intToInput(String message) {

        System.out.println(message);
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();

        int inputInt;
        try {
            inputInt = Integer.parseInt(userInput);
        } catch (Exception e) {
            return waitForInt("Noah pities fools that can't tell letters from numbers!!...try again, Darwin:");
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

    public void menuList(List<Animal> animalList) {

        System.out.println("\n-+- Critters aboard: -+-\n");

        if (animalList.size() == 0) {
            System.out.println("\nArk's empty!  Go trap something.\n");
        } else {
            for (int x = 0; x < animalList.size(); x++) {
                Animal animal = animalList.get(x);
                System.out.printf("%s) %s\n", (x + 1) + ".", animal.getName() + "\n", x);
            }
        }
        //System.out.println();
    }


    public Animal menuCreate() {

        System.out.println("-+- Create Critter -+-\n");
        String name = waitForString("Critter Name:?: ", true);
        String species = waitForString("Critter species:?: ", true);
        String breed = waitForString("Critter breed:?: ", true);
        String details = waitForString("Critter specifics (optional):?: ", "[Empty]");

        System.out.printf("Congrats, %s has been begat!\n", name);
        return new Animal(name, species, breed, details);

    }


    public Animal menuView(Animal animal) {

        System.out.printf(
            "\n" +
                "Name: %s\n" +
                "Species: %s\n" +
                "Breed: %s\n" +
                "Description: %s\n",
            animal.getName(),
            animal.getSpecies(),
            animal.getBreed(),
            animal.getDescription());
        return animal;
    }

    public Animal menuEdit(Animal animal) {


        System.out.println("\nNew values for... " + animal.getName() + " ('enter' for current):?:");

        String name = waitForString(
            String.format("Name [%s]:?: ", animal.getName()),
            animal.getName());
        String species = waitForString(
            String.format("Species [%s]:?: ", animal.getSpecies()),
            animal.getSpecies());
        String breed = waitForString(
            String.format("Breed [%s]:?: ", animal.getBreed()),
            animal.getBreed());
        String description = waitForString(
            String.format("Specifics [%s]:?:", animal.getDescription()), animal.getDescription());

        return new Animal(name, species, breed, description);
    }

    public void deleteAnimal() throws IOException {


        //AnimalRepository animalsList;
    }

//        System.out.println("Congrats Lord Homo, " + "'" + Animal.getName(input) + "' is now extinct.  One less bowl to fill!");
//    }

    public void displayNoSuchAnimal() {
        System.out.println("\nThat animal's either already et or otherwise dispatched.\n");

    }
}

