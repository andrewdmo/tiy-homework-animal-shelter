import java.util.ArrayList;

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
    static ArrayList masterList = new ArrayList();

    //override toString in case needed:
    public String toString(ArrayList masterList) {
        return toString();
    }

    //constructor:
    public Animal(/*int indexNum,*/ String name, String species, String breed, String description) {

        indexNum = indexNum + 1;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.description = description;

        //build master:

        masterList.add(indexNum);
        masterList.add(name);
        masterList.add(species);
        masterList.add(breed);
        masterList.add(description);
    }

    //settin':

    public void setIndexNum(int indexNum) {
        this.indexNum = indexNum;
    }

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
    public static ArrayList getmasterList() {
        return masterList;
    }


    public static ArrayList listEditor(ArrayList editedList) {
        masterList = editedList;
        return masterList;
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

}