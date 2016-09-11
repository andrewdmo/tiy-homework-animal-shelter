/**
 * 1
 * Created by andrewdmo on 8/19/16, beta done 8.30.
 */
//now I see why they outsource:

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        AnimalRepository animalRepository = new AnimalRepository("animals.json");
        AnimalService animalService = new AnimalService(animalRepository);
        MenuService menuService = new MenuService(animalService);
        //Animal animal = null;

        int userInput = menuService.waitForInt("Which number, man:?:");

        while (true) {


            if (userInput == 1) {
                //Animal animal = animalService.getAnimal(userInput);
                List<Animal> animalListing = animalService.listAnimal();
                    menuService.menuList(animalListing);
                userInput = menuService.waitForInt("Next unnatural selection:?:");




            } else if (userInput == 2) {
                Animal animal = menuService.menuCreate();
                animalService.createAnimal(animal);
                userInput = menuService.waitForInt("Another number:?:");



            } else if (userInput == 3) {
                System.out.printf("-+- View Critter Specifics -+-\n\n");
                userInput = menuService.intToInput("Critter number:?:", 1, MenuService.length);

                Animal animal = animalService.viewAnimal(userInput-1);

                if(animal != null){
                    menuService.menuView(animal);
                } else {
                    menuService.displayNoSuchAnimal();
                }
                userInput = menuService.waitForInt("Another number:?:");


            } else if (userInput == 4) {

                System.out.println("-+- Splice Critter's Genes: -+-\n");
                userInput = menuService.intToInput(" Critter number (from List):?:", 1, MenuService.length);
                Animal animal = animalService.getAnimal(userInput-1);

                if(animal != null){
                    // update the widget data
                    animal = menuService.menuEdit(animal);

                    // update the widget
                    animalService.editAnimal(userInput, animal);
                } else {
                    menuService.displayNoSuchAnimal();
                }
                userInput = menuService.waitForInt("Another number:?:");


            } else if (userInput == 5) {
                System.out.println("\n-+- Decease Critter -+-\n");
                int input = menuService.intToInput(" Animal number (from List):?:", 1, MenuService.length);

                animalService.deleteAnimal(input-1);
                userInput = menuService.waitForInt("Another number:?:");

            } else if (userInput == 6) {
                System.out.println("\n-+- Fine, enjoy extinction!... -+-");
                break;
            }
        }
    }
}