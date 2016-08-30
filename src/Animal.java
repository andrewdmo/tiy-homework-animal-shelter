import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by andrewdmo on 8/19/16.
 */
public class Animal {

    //private properties:
    private static int indexNum;
    private String name;
    private String species;
    private String breed;
    private String description;

    //will need:
    static ArrayList listBuilder = new ArrayList();

    //override toString:
    public String toString(ArrayList listBuilder) {
        return toString();
    }

    //constructor:
    public Animal(/*int indexNum*/ String name, String species, String breed, String description) {

        indexNum = indexNum + 1;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.description = description;

        //build master list:

        listBuilder.add(indexNum);
        listBuilder.add(name);
        listBuilder.add(species);
        listBuilder.add(breed);
        listBuilder.add(description);


    }

    //settin':

    public void setIndexNum(int indexNum) {this.indexNum  = indexNum; }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setDescription(String description) {
        this.description = breed;
    }

    //gettin':

    //'read only' (no setter):
    public static ArrayList getListBuilder() {
        return listBuilder;
    }

    public static ArrayList listEditor(ArrayList editedList) {
        listBuilder = editedList;
        return listBuilder;
    }

    public int getIndexNum() {
        return indexNum;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public String getDescription() {
        return description;
    }


    //method called from AS:
//    public static String makeList() {
//
//        return listBuilder.toString();
//    }

//    public static String editedList(int, String editValue) {
//
//        listBuilder.set((editValue + 1), )



        //System.out.println(listBuilder.toString());



}
//return makeList;

//    public ArrayList newList<>() {
//        return makeList;

//return makeList;
//list setup:

//        //method should add new entries to listBuilder:
//    public static ArrayList<String> listBuilder() {
//            ArrayList<String> listBuilder;
//        //(name,species, breed, description) {
//
//            listBuilder.add(name);
//            listBuilder.add(species);
//            listBuilder.add(breed);
//            listBuilder.add(description);
//            return listBuilder;
//            //listBuilder = listBuilder;
//            //makeList(listBuilder);


