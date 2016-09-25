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

<<<<<<< HEAD


    //override toString in case needed:
    public String toString(ArrayList masterList) {
        return toString();
    }

=======
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6
    //constructor:
    public Animal(/*int indexNum,*/ String name, String species, String breed, String description) {

        indexNum = indexNum + 1;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.description = description;
<<<<<<< HEAD



            //build master:

=======
>>>>>>> 0299f688015963c92dcc6d8799c72af1407a70a6
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