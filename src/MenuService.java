import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by andrewdmo on 8/19/16.
 */
public class MenuService {
    //  int preNum = 0;

    public MenuService() {
        System.out.println("\n-+- Welcome to Noah's Park, human!! -+- \n | \n-+- ...we're all endangered here!! -+-\n | ");

        //(default animals:)
        Animal example1 = new Animal("Fido", "dog", "wolf", "He's a runt");
        Animal example2 = new Animal("Simba", "cat", "scaredy", "1 life left");
    }

    public static int waitForInt(String defaultQues) {

        System.out.println("-+- Mane Menewe: -+-\n" + "\n" +
            "1) List critters\n" +
            "2) Create critter\n" +
            "3) Critter specifics \n" +
            "4) Edit critter\n" +
            "5) Delete critter\n" +
            "6) Quit(ter)");

        return intToInput(defaultQues);
    }

    public static int intToInput(String defaultQues, int min, int max) {

        System.out.println(defaultQues);
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();
        //credit to IntelliJ:
        AtomicInteger privInput = new AtomicInteger();
        try {
            privInput.set(Integer.parseInt(userInput));

            if (privInput.get() > max || privInput.get() < min) {
                return waitForInt("Noah pities the fool!...number in range:");
            }
        } catch (Exception e) {
            return waitForInt("Noah pities fools that can't tell letters from numbers!!...try again, Darwin:");
        }
        return privInput.get();
    }

    public static int intToInput(String message) {

        System.out.println(message);
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();
        //credit to IntelliJ:
        AtomicInteger privInput = new AtomicInteger();
        try {
            privInput.set(Integer.parseInt(userInput));

            if (privInput.get() > 6 || privInput.get() < 1) {
                return waitForInt("Noah pities the fool!...number in range:");
            }
        } catch (Exception e) {
            return waitForInt("Noah pities fools that can't tell letters from numbers!!...try again, Darwin:");
        }
        return privInput.get();
    }


    public static void listAnimal() {

        //instantiate, originally used makeList from AS:
        //NEED TO FORMAT (just Name and species)
        ArrayList currentList = Animal.masterList;
        System.out.println("\n-+- Critters aboard: -+-\n");
        System.out.println(currentList);
        //System.out.println(currentList.toString());
    }

    public static void /*String/*[]*/ createAnimal() {

        //instantiate::
        AnimalsService newAnimal = new AnimalsService();

        System.out.println("-+- Create Critter -+-\n");
        //name:
        System.out.println("Critter name:?:");
        Scanner action = new Scanner(System.in);
        String name = action.nextLine();
        try {
            if (name != "");
        } catch (Exception e) {
            System.out.println("Not valid, mortal");
            createAnimal();
        }   //species:
        System.out.println("Critter species:?:");
        action = new Scanner(System.in);
        String species = action.nextLine();
        try {
            if (species != "") ;
        } catch (Exception e) {
            System.out.println("Not valid, mortal");
            createAnimal();
        }   //breed:
        System.out.println("Critter breed:?:");
        action = new Scanner(System.in);
        String breed = action.nextLine();
        try {
            if (breed != "") {
            }
        } catch (Exception e) {
            System.out.println("Not valid, mortal");
            createAnimal();
        }  //description:
        System.out.println("(Optional) Critter specifics:?:");
        action = new Scanner(System.in);
        String description = action.nextLine();
        //instantiate:
        Animal tempAnimal = newAnimal.createAnimal(name, species, breed, description);
        //return to:
        System.out.println("\nCongrats, " + tempAnimal.getName() + " has just been begotten!\n");
    }

    public static void viewAnimalDetails() {
        System.out.println("-+- View Critter -+-\n");
        System.out.println(" Critter's number?:?");

        /////////search by name?
        Scanner action = new Scanner(System.in);
        String userInput2 = action.nextLine();
        int viewInput = Integer.parseInt(userInput2);

        //////exception handler +++   "Name:" list(1)
        String animalDetails = AnimalsService.viewAnimal(viewInput);
        System.out.println(animalDetails);
    }

    public static void editAnimal() {

        Scanner action = new Scanner(System.in);


        ArrayList thisEdit = AnimalsService.currentList;
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
        AnimalsService.editAnimal(thisEdit);
    }
    //////exceptions!! inputs / valid # no zeroes/ int

    public static void deleteAnimal() {
        ArrayList deleteList = AnimalsService.currentList;

        System.out.println("\n-+- Decease Critter -+-\n");
        System.out.println(" Animal number (from List):?:");

        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();
        int deleteInput = Integer.parseInt(userInput);

        String deadName = AnimalsService.getName(deleteInput);
        AnimalsService.deleteAnimal(deleteInput);
        System.out.println("Congrats Lord Homo, " + "'" + deadName + "' is now extinct.  One less bowl to fill!");
    }
}

