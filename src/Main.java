/**
 * 1
 * Created by andrewdmo on 8/19/16, beta done 8.30.
 */
//now I see why they outsource:
public class Main {
    Animal animal;
    AnimalsService animalsService = new AnimalsService(animal);
    MenuService menuService = new MenuService(animalsService);


    public void main(String[] args) {

       // MenuService menu = new MenuService();
        int userInput = menuService.waitForInt("Which number, man:?:");

        while (true) {

            if (userInput == 1) {
                menuService.listAnimal();
                userInput = menuService.waitForInt("Another number:?:");
            } else if (userInput == 2) {
                menuService.createAnimal();
                //callMenuService();
                userInput = menuService.waitForInt("Another number:?:");
            } else if (userInput == 3) {
                menuService.viewAnimalDetails();
                userInput = menuService.waitForInt("Another number:?:");
            } else if (userInput == 4) {
                menuService.editAnimal();
                userInput = menuService.waitForInt("Another number:?:");
            } else if (userInput == 5) {
                menuService.deleteAnimal();
                userInput = menuService.waitForInt("Another number:?:");
            } else if (userInput == 6) {
                System.out.println("\n-+- Fine, enjoy extinction!... -+-");
                break;
            }
        }
    }
}