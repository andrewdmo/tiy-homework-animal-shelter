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

        //public class MenuService() {
        MenuService menu = new MenuService();
        int userInput = MenuService.waitForInt();

        while (true) {

            if (userInput == 1) {
                MenuService.listAnimal();
                userInput = MenuService.intToInput("Enter another number, fool:"/*, null*/);
            } else if (userInput == 2) {
                MenuService.createAnimal();
                //callMenuService();
                userInput = MenuService.intToInput("Enter another number, fool:");
            } else if (userInput == 3) {
                MenuService.viewAnimalDetails();
                userInput = MenuService.intToInput("Enter another number, fool:");
            } else if (userInput == 4) {
                MenuService.editAnimal();
                userInput = MenuService.intToInput("Enter another number, fool:");
            } else if (userInput == 5) {
                MenuService.deleteAnimal();
                userInput = MenuService.intToInput("Enter another number, fool:");
            } else if (userInput == 6) {
                System.out.println("\n-+- Fine then, enjoy extinction!... -+-");
                break;
            } else MenuService.waitForInt();
        }
    }

    private static void main(int newInput) {
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