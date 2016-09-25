import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by andrewdmo on 8/19/16.
 */
public class MenuService {

   AnimalsService animalsService = new AnimalsService();
    ArrayList<Animal> currentList = animalsService.listAnimals();


    public MenuService(AnimalsService animalsService) {

        System.out.println("\n-+- Welcome to Noah's Park, human!! -+- \n | \n-+- ...we're all endangered here!! -+-\n | ");

        //(default animals:)
        Animal example1 = new Animal("Fido", "dog", "wolf", "He's a runt");
        Animal example2 = new Animal("Simba", "cat", "scaredy", "1 life left");
    }

    public int waitForInt(String defaultQues) {

        System.out.println("-+- Mane Menewe: -+-\n" + "\n" +
            "1) List critters\n" +
            "2) Create critter\n" +
            "3) Critter specifics \n" +
            "4) Edit critter\n" +
            "5) Delete critter\n" +
            "6) Quit(ter)");

        return intToInput(defaultQues);
    }

    public int intToInput(String defaultQues, int min, int max) {

        System.out.println(defaultQues);
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();

        int privInput;

        try {
            privInput = Integer.parseInt(userInput);

            if (privInput > max || privInput < min) {
                return waitForInt("Noah pities the fool!...number in range:");
            }
        } catch (Exception e) {
            return waitForInt("Noah pities fools that can't tell letters from numbers!!...try again, Darwin:");
        }

        return privInput;
    }

    public int intToInput(String message) {

        System.out.println(message);
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();
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

        //instantiate::
        AnimalsService newAnimal = new AnimalsService();

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

        Scanner action = new Scanner(System.in);


        ArrayList thisEdit = animalsService.masterList;
        System.out.println("-+- Splice Critter's Genes: -+-\n");
        int max = thisEdit.size();
        int editInput = intToInput(" Animal number (from List):?:", 1, max - 4);
        int editIndex = 5 * editInput - 5;

        String editName = thisEdit.get(editIndex + 1).toString();
        System.out.println("New values for...(Enter for current value:?:\n " + editInput + ". " + editName);

        System.out.println("\nName:?: [" + editName + "]");
        String newName = action.nextLine();
        if (newName.equals("")) {
            thisEdit.set(editIndex + 1, editName);
        } else {
            thisEdit.set(editIndex + 1, newName);
        }

        String editSpecies = thisEdit.get(editIndex + 2).toString();
        System.out.println("\nSpecies:?: [" + editSpecies + "]");
        String newSpecies = action.nextLine();
        if (newSpecies.equals("")) {
            thisEdit.set(editIndex + 2, editSpecies);
        } else {
            thisEdit.set(editIndex + 2, newSpecies);
        }

        String editBreed = thisEdit.get(editIndex + 3).toString();
        System.out.println("\nBreed:?: [" + editBreed + "]");
        String newBreed = action.nextLine();
        if (newBreed.equals("")) {
            thisEdit.set(editIndex + 3, editBreed);
        } else {
            thisEdit.set(editIndex + 3, newBreed);
        }

        String editDescription = thisEdit.get(editIndex + 4).toString();
        System.out.println("\nSpecifics:?: [" + editDescription + "]");
        String newDetails = action.nextLine();
        if (newDetails.equals("")) {
            thisEdit.set(editIndex + 4, editDescription);
        } else {
            thisEdit.set(editIndex + 4, newDetails);
        }
        animalsService.editAnimal(thisEdit);
    }
    //////exceptions!! inputs / valid # no zeroes/ int

    public void deleteAnimal() {
        ArrayList deleteList = animalsService.masterList;
        AnimalsService animalsService = new AnimalsService();

        System.out.println("\n-+- Decease Critter -+-\n");
        System.out.println(" Animal number (from List):?:");

        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();
        int deleteInput = Integer.parseInt(userInput);

        String deadName = animalsService.getName(deleteInput);
        animalsService.deleteAnimal(deleteInput);
        System.out.println("Congrats Lord Homo, " + "'" + deadName + "' is now extinct.  One less bowl to fill!");
    }
}

