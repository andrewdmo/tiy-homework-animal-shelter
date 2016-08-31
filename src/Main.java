/**
 * 1
 * Created by andrewdmo on 8/19/16.
 */

import sun.nio.cs.ext.MS874;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MenuService menu = new MenuService();
        int userInput = MenuService.waitForInt("TEST start");


        while (true) {

            if (userInput == 1) {
                MenuService.listAnimal();
                userInput = MenuService.waitForInt("TEST 1");
            } else if (userInput == 2) {
                MenuService.createAnimal();
                //callMenuService();
                userInput = MenuService.waitForInt("TEST 2");
            } else if (userInput == 3) {
                MenuService.viewAnimalDetails();
                userInput = MenuService.waitForInt("TEST 3");
            } else if (userInput == 4) {
                MenuService.editAnimal();
                userInput = MenuService.waitForInt("TEST 4");
            } else if (userInput == 5) {
                MenuService.deleteAnimal();
                userInput = MenuService.waitForInt("TEST 5");
            } else if (userInput == 6) {
                System.out.println("\n-+- Fine, enjoy extinction!... -+-");
                break;
            } //     } else MenuService.waitForInt("TEST last in while loop");
        }
    }
}



// int userInput = menu.waitForInt();
//public static void Main() {


//menu.waitForInt();


//System.out.println("userInput:" + userInput);


//


//    switch (userInput) {
//    case 1:
//    MenuService.listAnimal();
//
//    menu.waitForInt();
//    case 2:
//    MenuService.createAnimal();
//    //return userInput;
//    break;
//    case 3:
//    MenuService.viewAnimalDetails();
//    break;
//    case 4:
//    MenuService.editAnimal();
//    break;
//    case 5:
//    MenuService.deleteAnimal();
//    break;
//    case 6:
//    System.out.println("-+- Fine then... -+-");
//    break;
//default:
//    menu.waitForInt();
//    menu.waitForInt();