package mealpicker;

import java.io.*;

//TODO
// main menu: Start the program 1) NO - exit; 2) YES - choose action
// action: 1) enter random meal picker; 2) enter random recipe picker; 3) add new recipe; 4) stop program
// DB connection


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        char start = 'Y';
        char exit = 'N';
        char startingProgramInput;
        Scanner scanner = new Scanner(System.in);

        //Start of the program
        System.out.println("Welcome to Random Meal Picker");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Do you want to start the program?");
        System.out.println("Y for START; N for EXIT");

        startingProgramInput = scanner.nextLine().toUpperCase().charAt(0);
        if (startingProgramInput == 'Y') {
            startProgram();
        } else {
            System.out.println("Quiting program");
        }
    }

    private static void startProgram() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose action: 1,2,3,4");
        System.out.println("1 - Enter to Random Meal Picker");
        System.out.println("2 - Enter to Random Recipe Picker");
        System.out.println("3 - Add new recipe");
        System.out.println("4 - Stop the program");
        int choice = scanner.nextInt();

        //random Meal Picker
        if (choice == 1){
            //enter random meal picker
        } else if (choice == 2){
            //enter random recipe picker
        } else if (choice == 3){
            //addNewRecipe();
        } else if (choice == 4){
            System.exit(0);
        } else {
            System.out.println("Please choose an option from the list");
            choice = scanner.nextInt();
        }

    }
}
