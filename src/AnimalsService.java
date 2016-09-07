import java.util.*;

/**
 * Created by andrewdmo on 8/19/16.
 */
public class AnimalsService {

    static ArrayList currentList = Animal.masterList;

    public static String getName(int deleteInput) {
        Object cL = currentList.get(5 * deleteInput - 4);
        return cL.toString();
    }
    //method for menu 1:
    // just used Animal.masterList from MS
//    public static ArrayList makeList() {
//        return currentList;//    }


    //method for menu 2:
    //could do like above and call from MS
    public Animal createAnimal(String name, String species, String breed, String description) {

        //set instance w/ properties rolling in:
        Animal newAnimal = new Animal(name, species, breed, description);

        return newAnimal;
    }


    //method for menu 3:
    public static String viewAnimal(int viewInput) {

        //ArrayList currentList = Animal.masterList;

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
        Animal.listEditor(editedList);
        return currentList;
    }


    public static boolean deleteAnimal(int deleteInput) {
        //setup:
        ArrayList deleteList = AnimalsService.currentList;
        int indexPoint = deleteInput * 5 - 5;

        deleteList.subList(indexPoint, indexPoint + 5).clear();
        int newListSize = deleteList.size();
        int v = 1;
        for (int i = 0;
             i < newListSize;
             i = i + 5) {
            deleteList.set(i, v);
            v++;
        }
        Animal.listEditor(deleteList);

        return true;
    }

}














