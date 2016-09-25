import java.util.ArrayList;

/**
 * Created by andrewdmo on 8/19/16.
 */
public class AnimalsService {

    ArrayList<Animal> masterList = new ArrayList();

    public AnimalsService() {
        //will need:
    }

    public ArrayList listAnimals() {

        ArrayList currentList = null;

        int i;
        for (i = 0; i < masterList.size(); i++) {

            Animal viewAnimal = masterList.get(i);
            int viewIndex = viewAnimal.getIndexNum();
            String viewName = viewAnimal.getName();
            String viewSpecies = viewAnimal.getSpecies();
            String viewBreed = viewAnimal.getBreed();
            String viewDescription = viewAnimal.getDescription();


            currentList.add(viewIndex + ". \n" + viewName + "\n" + viewSpecies + "\n" + viewBreed + "\n" + viewDescription + "\n");
        }


        return currentList


        ;

    }

    public String getName(int deleteInput) {
        Animal namedAnimal = masterList.get(deleteInput);
        return namedAnimal.getName();
    }


    //method for menu 2:
    //could do like above and call from MS
    public Animal createAnimal(String name, String species, String breed, String description) {

        //set instance w/ properties rolling in:
        Animal newAnimal = new Animal(name, species, breed, description);

        //add to list:
        masterList.add(newAnimal);
        return newAnimal;
    }


    //method for menu 3:
    public String viewAnimal(int viewInput) {

        Animal viewAnimal = masterList.get(viewInput);

        // get values @ index:
        int viewIndex = viewAnimal.getIndexNum();
        String viewName = viewAnimal.getName();
        String viewSpecies = viewAnimal.getSpecies();
        String viewBreed = viewAnimal.getBreed();
        String viewDescription = viewAnimal.getDescription();

        return viewIndex + ". \n" + viewName + "\n" + viewSpecies + "\n" + viewBreed + "\n" + viewDescription;
    }


    public ArrayList editAnimal(ArrayList editedList) {
        Animal.listEditor(editedList);
        return masterList;
    }


    public boolean deleteAnimal(int deleteInput) {
        //setup:
        ArrayList deleteList = masterList;
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














