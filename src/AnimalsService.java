import java.util.ArrayList;

/**
 * Created by andrewdmo on 8/19/16.
 */
public class AnimalsService {

    static ArrayList currentList = Animal.listBuilder;

    //method for menu 1:
    public static String makeList() {

        return currentList.toString();

//        String listAnimal = Animal.makeList();
//        listAnimal = Animal.makeList();
//        return currentList;
    }


    //method for menu 2:
    public Animal createAnimal(String name, String species, String breed, String description) {

        //set instance w/ properties rolling in:
        Animal newAnimal = new Animal(name, species, breed, description);

        return newAnimal;
    }


    //method for menu 3:
    public static String viewAnimal(int viewInput) {

        //ArrayList currentList = Animal.listBuilder;

        //best math I've done in ages:
        int indexPoint = (5 * viewInput) - 5;
        int one = indexPoint + 1;
        int two = indexPoint + 2;
        int three = indexPoint + 3;
        int four = indexPoint + 4;

        // get values @ index:
        String listIndex = String.valueOf(viewInput);
        Object listName = currentList.get(one);
        Object listSpecies = currentList.get(two);
        Object listBreed = currentList.get(three);
        Object listDescription = currentList.get(four);

        return listIndex + ". " + listName + " " + listSpecies + " " + listBreed + " " + listDescription;
    }


    public static ArrayList editAnimal(ArrayList editedList) {

//        int editInput, String editName, String editSpecies, String editBreed, String editDescription

//        ArrayList currentList = Animal.listBuilder;
//        int indexPoint = (5 * editInput) - 5;
//        int one = indexPoint + 1;
//        int two = indexPoint + 2;
//        int three = indexPoint + 3;
//        int four = indexPoint + 4;

        System.out.println("pre-set TEST");
        System.out.println(currentList);
//        String listIndex = String.valueOf(editInput);
//        String listName = (currentList.get(one)).toString();
//        String listSpecies = (currentList.get(two)).toString();
//        String listBreed = (currentList.get(three)).toString();
//        String listDescription = (currentList.get(four)).toString();

//        Animal.listBuilder.set(one, editValue);
//        Animal.listBuilder.set(two, editValue);
//        Animal.listBuilder.set(three, editValue);
//        Animal.listBuilder.set(four, editValue);

        //listBuilder = editedList.set(editedList);

        Animal.listEditor(editedList);

        ArrayList currentList2 = currentList;

        //test:

        System.out.println("post-set TEST " + currentList2);


        return currentList;
    }


}














