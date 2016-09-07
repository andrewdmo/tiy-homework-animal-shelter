/**
 * 1
 * Created by andrewdmo on 8/19/16, beta done 8.30.
 */
//now I see why they outsource:
public class Main {

    public static void main(String[] args) {

        MenuService menu = new MenuService();
        int userInput = MenuService.waitForInt("Which number, man:?:");

        while (true) {

            if (userInput == 1) {
                MenuService.listAnimal();
                userInput = MenuService.waitForInt("Another number:?:");
            } else if (userInput == 2) {
                MenuService.createAnimal();
                //callMenuService();
                userInput = MenuService.waitForInt("Another number:?:");
            } else if (userInput == 3) {
                MenuService.viewAnimalDetails();
                userInput = MenuService.waitForInt("Another number:?:");
            } else if (userInput == 4) {
                MenuService.editAnimal();
                userInput = MenuService.waitForInt("Another number:?:");
            } else if (userInput == 5) {
                MenuService.deleteAnimal();
                userInput = MenuService.waitForInt("Another number:?:");
            } else if (userInput == 6) {
                System.out.println("\n-+- Fine, enjoy extinction!... -+-");
                break;
            }
        }
    }
}