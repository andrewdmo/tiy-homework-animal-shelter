//package Animal;
//import entity.Animal;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
<<<<<<< HEAD

=======
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6

/**
 * Created by andrewdmo on 8/19/16.
 */

public class MenuService {
<<<<<<< HEAD

   AnimalsService animalsService = new AnimalsService();
    ArrayList<Animal> currentList = animalsService.listAnimals();


    public MenuService(AnimalsService animalsService) {

        System.out.println("\n-+- Welcome to Noah's Park, human!! -+- \n | \n-+- ...we're all endangered here!! -+-\n | ");
=======
    //AnimalService animalService = new AnimalService();
    // int max = new AnimalService;

    //AnimalService animalService;
    //AnimalService animalService;



    public MenuService(AnimalService animalService) {
        int length = animalService.listAnimal().size();
        this.length = length;

        //this.animalService = new AnimalService();

        System.out.println("\n-+- Welcome to Noah's Park, human!! -+- \n | \n-+- ...we're all endangered here... -+-\n | ");
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6

        //(default animals:)
        Animal example1 = new Animal("Fido", "Dog", "Yipper", "He's a runt");
        Animal example2 = new Animal("Simba", "Cat", "Scaredy", "One life left");
    }

<<<<<<< HEAD
    public int waitForInt(String defaultQues) {
=======
    MenuService menuService;
    static int length = MenuService.length;
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6


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
<<<<<<< HEAD

        int privInput;

        try {
            privInput = Integer.parseInt(userInput);

            if (privInput > max || privInput < min) {
                return waitForInt("Noah pities the fool!...number in range:");
=======
        int inputInt;

        try {
            inputInt = Integer.parseInt(userInput);

            if (inputInt > max || inputInt < min) {
                return intToInput("Noah pities the fool!...number in range:");
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6
            }
        } catch (Exception e) {
            return intToInput("Noah pities fools that can't tell letters from numbers!!...try again, Darwin:");
        }
<<<<<<< HEAD

        return privInput;
=======
        return inputInt;
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6
    }

    public int intToInput(String message) {

        System.out.println(message);
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();
<<<<<<< HEAD
        //credit to IntelliJ:
        int privInput;
        try {
            privInput = Integer.parseInt(userInput);

            if (privInput > 6 || privInput < 1) {
                return waitForInt("Noah pities the fool!...number in range:");
            }
        } catch (Exception e) {
            return waitForInt("Noah pities fools that can't tell letters from numbers!!...try again, Darwin:");
        }
        return privInput;
    }

    private String waitForString(String message, boolean required) {
        System.out.println(message);
        Scanner action = new Scanner(System.in);
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


    public void listAnimal() {

        System.out.println("\n-+- Critters aboard: -+-\n");

        System.out.println(animalsService.listAnimals());




    }


    public Animal /*String/*[]*/ createAnimal() {
=======

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
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6

        if (input.isEmpty()) {
            return defaultInput;
        } else {
            return input;
        }
    }

<<<<<<< HEAD
        System.out.println("-+- Create Critter -+-\n");
        //name:
        String name = waitForString("Critter name:?:", true);
        //species:
        String species = waitForString("Critter species:?:", true);

        //breed:
        String breed = waitForString("Critter breed:?:", true);

        //description:
        String description = waitForString("(Optional) Critter specifics:?:", "[Empty]");

        //instantiate:
        Animal tempAnimal = newAnimal.createAnimal(name, species, breed, description);

        //return to:
        System.out.println("\nCongrats, " + tempAnimal.getName() + " has just been begat!\n");
        return tempAnimal;
    }

    public void viewAnimalDetails() {
        System.out.println("-+- View Critter -+-\n");
        listAnimal();

        //////exception handler +++   "Name:" list(1)
        String animalDetails = animalsService.viewAnimal(intToInput(" Critter's number?:?", 1, currentList.size()));
        System.out.println(animalDetails);
    }

    public void editAnimal() {
=======
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
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6


    public Animal menuView(Animal animal) {

<<<<<<< HEAD
        ArrayList thisEdit = animalsService.masterList;
        System.out.println("-+- Splice Critter's Genes: -+-\n");
        int max = thisEdit.size();
        int editInput = intToInput(" Animal number (from List):?:", 1, max - 4);
        int editIndex = 5 * editInput - 5;
=======
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
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6

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

<<<<<<< HEAD
        String editDescription = thisEdit.get(editIndex + 4).toString();
        System.out.println("\nSpecifics:?: [" + editDescription + "]");
        String newDetails = action.nextLine();
        if (newDetails.equals("")) {
            thisEdit.set(editIndex + 4, editDescription);
        } else {
            thisEdit.set(editIndex + 4, newDetails);
        }
        animalsService.editAnimal(thisEdit);
=======
        return new Animal(name, species, breed, description);
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6
    }

<<<<<<< HEAD
    public void deleteAnimal() {
        ArrayList deleteList = animalsService.masterList;
        AnimalsService animalsService = new AnimalsService();
=======
    public void deleteAnimal() throws IOException {
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6


        //AnimalRepository animalsList;
    }

//        System.out.println("Congrats Lord Homo, " + "'" + Animal.getName(input) + "' is now extinct.  One less bowl to fill!");
//    }

    public void displayNoSuchAnimal() {
        System.out.println("\nThat animal's either already et or otherwise dispatched.\n");

<<<<<<< HEAD
        String deadName = animalsService.getName(deleteInput);
        animalsService.deleteAnimal(deleteInput);
        System.out.println("Congrats Lord Homo, " + "'" + deadName + "' is now extinct.  One less bowl to fill!");
=======
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6
    }
}

