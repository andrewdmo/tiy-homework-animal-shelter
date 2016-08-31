import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by andrewdmo on 8/19/16.
 */
public class MenuService {
    //  int preNum = 0;

    public MenuService() {
        System.out.println("\n-+- Welcome to Noah's Park, human!! -+- \n | \n-+- ...we're all endangered here -+-\n | ");

        //(default animals:)
        Animal example1 = new Animal("Fido", "dog", "wolf", "He's a runt");
        Animal example2 = new Animal("Simba", "cat", "scaredy", "1 life left");
    }

    public static int waitForInt(String nextPrompt) {

        System.out.println("-+- Mane Menewe: -+-\n" + "\n" +
            "1) List critters\n" +
            "2) Create critter\n" +
            "3) Critter specifics \n" +
            "4) Edit critter\n" +
            "5) Delete critter\n" +
            "6) Quit(ter)");

        return intToInput(nextPrompt);
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

        //instantiate:
        ArrayList currentList = AnimalsService.makeList();
        System.out.println("\n-+- Critters aboard: -+-\n");
        System.out.println(currentList);
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
            if (name != null) ;
        } catch (Exception e) {
            System.out.println("Not valid, mortal");
            //bumps back:
            createAnimal();
        }   //species:
        System.out.println("Critter species:?:");
        action = new Scanner(System.in);
        String species = action.nextLine();
        try {
            if (species != null) ;
        } catch (Exception e) {
            System.out.println("Not valid, mortal");
            createAnimal();
        }   //breed:
        System.out.println("Critter breed:?:");
        action = new Scanner(System.in);
        String breed = action.nextLine();
        try {
            if (breed != null) {
            }
        } catch (Exception e) {
            System.out.println("Not valid, mortal");
            createAnimal();
        }   //description:
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

        ArrayList thisEdit = AnimalsService.currentList;
        System.out.println("-+- Splice Critter's Genes: -+-\n");
        System.out.println(" Animal number (from List):?:");

        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();
        int editInput = Integer.parseInt(userInput);

        int editIndex = (5 * editInput - 5);
        String editName = thisEdit.get(editIndex + 1).toString();
        System.out.println("New values for...(Enter for current value:?:\n " + editInput + ". " + editName);

        System.out.println("\nName:?: [" + editName + "]");
        String userInput1 = action.nextLine();
        if (userInput1.equals("")) {
            thisEdit.set(editIndex + 1, editName);
        } else {
            thisEdit.set(editIndex + 1, userInput1);
        }

        String editSpecies = thisEdit.get(editIndex + 2).toString();
        System.out.println("\nSpecies:?: [" + editSpecies + "]");
        String userInput2 = action.nextLine();
        if (userInput2.equals("")) {
            thisEdit.set(editIndex + 2, editSpecies);
        } else {
            thisEdit.set(editIndex + 2, userInput2);
        }

        String editBreed = thisEdit.get(editIndex + 3).toString();
        System.out.println("\nBreed:?: [" + editBreed + "]");
        String userInput3 = action.nextLine();
        if (userInput3.equals("")) {
            thisEdit.set(editIndex + 3, editBreed);
        } else {
            thisEdit.set(editIndex + 3, userInput3);
        }

        String editDescription = thisEdit.get(editIndex + 4).toString();
        System.out.println("\nSpecifics:?: [" + editDescription + "]");
        String userInput4 = action.nextLine();
        if (userInput4.equals("")) {
            thisEdit.set(editIndex + 4, editDescription);
        } else {
            thisEdit.set(editIndex + 4, userInput3);
        }
        AnimalsService.editAnimal(thisEdit);
    }
    //////limit inputs / valid # no zeroes/ int


    public static void deleteAnimal() {
        System.out.println("-+- Decease Critter [del] -+-");


    }
}

