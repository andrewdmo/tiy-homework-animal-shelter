/**
 * 1
 * Created by andrewdmo@gmail.com on 8/19/16, beta done 8.30.
 */

//    (now I see why they outsource)

import entity.Animal;
import repository.AnimalRepository;
import repository.AnimalTypeRepository;
import service.AnimalService;
import service.MenuService;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/animalshelter";

        AnimalRepository animalRepository = new AnimalRepository(jdbcUrl);

        AnimalTypeRepository animalTypeRepository = new AnimalTypeRepository(jdbcUrl);

        AnimalService animalService = new AnimalService(animalRepository, animalTypeRepository);

        MenuService menuService = new MenuService(animalService, animalTypeRepository);

        ArrayList<Animal> animals = animalService.listAnimal();

        int userInput = menuService.waitForInt("Which number, man:?:");

        while (true) {
            //need to renumber menus:

            //CREATE:
            if (userInput == 1) {

                menuService.menuCreate(animalService, animalTypeRepository);

                userInput = menuService.waitForInt("Next unnatural selection:?:");

             //MANAGE:
            } else if (userInput == 2) {
                menuService.menuManage("DEFAULT");

                userInput = menuService.waitForInt("Next unnatural selection:?:");

             //TYPES:
            } else if (userInput == 3) {

                //menuService.menuType(animalService);

                userInput = menuService.waitForInt("Next unnatural selection:?:");


            } else if (userInput == 4) {

                System.out.println("\n-+- Fine, enjoy extinction!... -+-");
                break;

//            } else if (userInput == 5) {
//
//                menuService.menuDelete(animalService);
//
//                userInput = menuService.waitForInt("Next unnatural selection:?:");
//
//
//            } else if (userInput == 6)
//            System.out.println("***uncalled exit***");

            }
        }
    }
}

//Genes: -+-\n");
//                userInput = menuService.intToInput(" Critter number (from List):?:", 1, 10);
//                entity.Animal animal = animalService.getAnimal(userInput-1);

//                if(animal != null){
// update the widget data
//                    animal = menuService.menuEdit(animal);

// update the widget
//                    animalService.editAnimal(userInput, animal);
//                } else {
//                    menuService.displayNoSuchAnimal();
//                }
//userInput = menuService.waitForInt("Another number:?:");
//        }


//            } else if (userInput == 5) {
//                System.out.println("\n-+- Decease Critter -+-\n");
//                int input = menuService.intToInput(" entity.Animal number (from List):?:", 1, 10);
//
//                //animalService.deleteAnimal(input-1);
//
//            userInput = menuService.waitForInt("Another number:?:");
//
////            } else if (userInput == 6) {
////                System.out.println("\n-+- Fine, enjoy extinction!... -+-");
//        //  break;
//
//    }
//
//}
//
