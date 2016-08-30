import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by andrewdmo on 8/19/16.
 */
public class MenuService {
    public MenuService() {
        System.out.println("\n-+- Welcome to Noah's Park, human user!! -+- \n | \n-+- ...we're all endangered here -+-\n");

        //(default animals:)
        Animal example1 = new Animal("Fido", "dog", "wolf", "He's a runt");
        Animal example2 = new Animal("Simba", "cat", "scardy", "one life left");
    }

    public static int waitForInt() {

        System.out.println("\n-+- Mane Menewe: -+-\n" + "\n" +
            "1) List critters\n" +
            "2) Create a critter\n" +
            "3) View critter details\n" +
            "4) Edit a critter\n" +
            "5) Delete a critter\n" +
            "6) Quit(ter)\n");

        return (intToInput("Enter a number, mortal:"));
    }

    public static int intToInput(String message) {

        System.out.println(message);
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();

        AtomicInteger privInput = new AtomicInteger();
        //credit to IntelliJ:
        try {
            privInput.set(Integer.parseInt(userInput));
            if (privInput.get() > 6 || privInput.get() < 1) {
                intToInput("Noah pities the fool, choose a number in range:"/*, privInput*/);
            }
        } catch (Exception e) {
            intToInput("Noah pities fools that can't tell letters from numbers, try again:"/*, privInput*/);

        }
//            try {
//                privInput = Integer.parseInt(userInput);
//            } catch (Exception e2) {
//                intToInput("fail");
//                privInput = 1;
        return privInput.get();
    }


    public static void listAnimal() {

        //instantiate:
        String listAnimal = AnimalsService.makeList();
        System.out.println("\n-+- List o' Critters currently aboard: -+-\n");
        System.out.println(listAnimal);
    }

    public static void /*String/*[]*/ createAnimal() {

        //instantiate::
        AnimalsService newAnimal = new AnimalsService();

        System.out.println("-+- Create a Critter -+-\n");
        //name:
        System.out.println(" Critter name:");
        Scanner action = new Scanner(System.in);
        String name = action.nextLine();
        try {
            if (name != null) ;
        } catch (Exception e) {
            System.out.println("Not valid, fool");
            //bumps back:
            createAnimal();
        }   //species:
        System.out.println("Critter species:");
        action = new Scanner(System.in);
        String species = action.nextLine();
        try {
            if (species != null) ;
        } catch (Exception e) {
            System.out.println("Not valid, fool");
            createAnimal();
        }   //breed:
        System.out.println("Critter breed:");
        action = new Scanner(System.in);
        String breed = action.nextLine();
        try {
            if (breed != null) {
            }
        } catch (Exception e) {
            System.out.println("Not valid, fool");
            createAnimal();
        }   //description:
        System.out.println("Critter description (if you're inclined):");
        action = new Scanner(System.in);
        String description = action.nextLine();
        //instantiate:
        Animal tempAnimal = newAnimal.createAnimal(name, species, breed, description);
        //return to:
        System.out.println("\nCongrats, " + tempAnimal.getName() + " has been created\n");

        //return waitForInt();

    }

    public static void viewAnimalDetails() {
        System.out.println("-+- View a Critter -+-\n");
        System.out.println(" Choose animal number (from List)");

        /////////search by name?
        Scanner action = new Scanner(System.in);
        String userInput2 = action.nextLine();
        int viewInput = Integer.parseInt(userInput2);

        //////limit inputs / valid # no zeroes/ int
        String animalDetails = AnimalsService.viewAnimal(viewInput);
        System.out.println(animalDetails);
    }

    public static void editAnimal() {

//        AnimalsService.editAnimal();
        System.out.println("-+- Edit a Critter's Genes / Play God: -+-\n");
        System.out.println(" Choose animal number (from List):");

        /////////search by name?
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();
        int editInput = Integer.parseInt(userInput);
        ArrayList thisEdit = AnimalsService.currentList;
//        final ArrayList editListFinal = thisEdit;
//        thisEdit.get(editInput + 1);
//           (AnimalsService.thisEdit.get(editInput + 1)));
        int editIndex = (5 * editInput - 5);
        String editName = thisEdit.get(editIndex + 1).toString();
        System.out.println("\n Enter new values for:\n " + editInput + ". "+ editName + "\nPress Enter to keep [current] value:");

        //above: String editName = thisEdit.get(editIndex + 1).toString();
        System.out.println("\nName: [" + editName + "]");
        String userInput1 = action.nextLine();
        if (userInput1 == null) {
            thisEdit.set(editIndex + 1, editName);
        } else {
        thisEdit.set(editIndex + 1, userInput1);
        //AnimalsService.editAnimal(editInput, userInput1);
        }

        String editSpecies = thisEdit.get(editIndex +2).toString();
        System.out.println("\nSpecies: [" + editSpecies + "]");
        String userInput2 = action.nextLine();
        if (userInput2 == null) {
            thisEdit.set(editIndex+2, editSpecies);
        } else {
            thisEdit.set(editIndex + 2, userInput2);
        }

        String editBreed = thisEdit.get(editIndex+3).toString();
        System.out.println("\nBreed: [" + editBreed + "]");
        String userInput3 = action.nextLine();
        if (userInput3 == null) {
            thisEdit.set(editIndex+3, editBreed);
        } else {
            thisEdit.set(editIndex+3, userInput3);
        }

        String editDescription = thisEdit.get(editInput +4).toString();
        System.out.println("\nDescription: [" + editDescription + "]");
        String userInput4 = action.nextLine();
        if (userInput4 == null) {
            thisEdit.set(editIndex+4, editDescription);
        } else {
            thisEdit.set(editIndex+4, userInput4);
        }
        AnimalsService.editAnimal(thisEdit);

    }



    //////limit inputs / valid # no zeroes/ int

    //System.out.println(editAnimal);


    public static void deleteAnimal() {
        System.out.println("-+- Put a critter down (delete) -+-");

    }
}


//return;
//privInput = waitForInt();
//int input = Integer.parseInt(userInput);
//return privInput;

//catch (ArithmeticException)
//privInput = waitForInt();
//            try {
//                privInput = Integer.parseInt(userInput);
//            } catch (NumberFormatException e) {
//                intToInput("Noah pities fools that can't tell letters from numbers, try again:");
//            }
//            return privInput;

// int privInput = Integer.parseInt(userInput);

