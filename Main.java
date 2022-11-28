package mealpicker;

import java.io.*;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char startingProgramInput;
        Scanner scanner = new Scanner(System.in);

        //Start of the program
        System.out.println("Welcome to Random Meal Picker");
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Do you want to start the program?");
        System.out.println("Y for START; N for EXIT");

        startingProgramInput = scanner.nextLine().toUpperCase().charAt(0);
        if (startingProgramInput == 'Y') {
            startProgram();
        } else if (startingProgramInput == 'N') {
            System.out.println("Quiting program");
            System.exit(0);
        } else {
            System.out.println("Please choose either Y or N");
            startingProgramInput = scanner.nextLine().toUpperCase().charAt(0);
            while (startingProgramInput == 'Y') {
                startProgram();
            }
        }
    }

    private static void startProgram() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose action: 1,2,3,4");
        try {
            Thread.sleep(700);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("1 - Enter to Random Meal Picker");
        System.out.println("2 - Enter to Random Recipe Picker");
        System.out.println("3 - Add new recipe");
        System.out.println("4 - Stop the program");
        int choice = scanner.nextInt();

        //Choose action
        if (choice == 1) {
            randomMealPicker();
        } else if (choice == 2) {
            randomRecipePicker();
        } else if (choice == 3) {
            try {
                addRecipe();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (choice == 4) {
            System.exit(0);
        } else {
            System.out.println("Please choose an option from the list");
            choice = scanner.nextInt();
        }

    }

    public static void randomMealPicker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose your meal time: B, L or D");

        System.out.println("B - breakfast");
        System.out.println("L - lunch");
        System.out.println("D - dinner");

        String mealTime = scanner.nextLine().toUpperCase().trim();

        System.out.println("Please choose season: W, SP, SU, A");

        System.out.println("W - winter");
        System.out.println("SP - spring");
        System.out.println("SU - summer");
        System.out.println("A - autumn");

        String season = scanner.nextLine().toUpperCase().trim();

        if (season.equals("W")) {
            season = "winter";
        } else if (season.equals("SP")) {
            season = "spring";
        } else if (season.equals("SU")) {
            season = "summer";
        } else if (season.equals("A")) {
            season = "autumn";
        }
        if (mealTime.equals("B")) {
            mealTime = "breakfast";
        } else if (mealTime.equals("L")) {
            mealTime = "lunch";
        } else if (mealTime.equals("D")) {
            mealTime = "dinner";
        }

        DBInteractionMealPicker dbInteraction = new DBInteractionMealPicker();

        dbInteraction.randomForAll(season, mealTime);
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        startProgram();
    }

    public static void randomRecipePicker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose your meal time: B, L or D");

        System.out.println("B - breakfast");
        System.out.println("L - lunch");
        System.out.println("D - dinner");

        String mealTime = scanner.nextLine().toUpperCase().trim();

        System.out.println("Please choose season: W, SP, SU, A");

        System.out.println("W - winter");
        System.out.println("SP - spring");
        System.out.println("SU - summer");
        System.out.println("A - autumn");

        String season = scanner.nextLine().toUpperCase().trim();

            if (season.equals("W")) {
                season = "winter";
            } else if (season.equals("SP")) {
                season = "spring";
            } else if (season.equals("SU")) {
                season = "summer";
            } else if (season.equals("A")) {
                season = "autumn";
            }
            if (mealTime.equals("B")) {
                mealTime = "breakfast";
            } else if (mealTime.equals("L")) {
                mealTime = "lunch";
            } else if (mealTime.equals("D")) {
                mealTime = "dinner";
            }

            DBInteractionRecipePicker dbInteractionRecipePicker = new DBInteractionRecipePicker();

            if(dbInteractionRecipePicker.randomForRecipe(season, mealTime)) {
                dbInteractionRecipePicker.randomForRecipe(season, mealTime);
            } else {
                try {
                    Thread.sleep(1500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                startProgram();
            }
    }

    public static void addRecipe() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String RecipeName = "";

        System.out.println("Enter Recipe name");
        while (RecipeName.length() < 3) {
            System.out.println("Please enter at least 3 letters");
            RecipeName = scanner.nextLine();
        }

        System.out.println("Please enter the meal time - B, L or D");
        String mealTime = scanner.nextLine().toUpperCase().trim();
        int breakfast = 0;
        int lunch = 0;
        int dinner = 0;

        if (mealTime.equals("B")) {
            breakfast = 1;
        } else if (mealTime.equals("L")) {
            lunch = 1;
        } else if (mealTime.equals("D")) {
            dinner = 1;
        } else {
            System.out.println("You need to enter either 'B', 'L' or 'D'");
            mealTime = scanner.nextLine().toUpperCase().trim();
        }

        System.out.println("Please enter the season - W, SP, SU, A");
        String season = scanner.nextLine().toUpperCase().trim();
        int winter = 0;
        int spring = 0;
        int summer = 0;
        int autumn = 0;

        if (season.equals("W")) {
            winter = 1;
        } else if (season.equals("SP")) {
            spring = 1;
        } else if (season.equals("SU")) {
            summer = 1;
        } else if (season.equals("A")) {
            autumn = 1;
        } else {
            System.out.println("You need to enter either 'W', 'SP', 'SU' or 'A'");
            season = scanner.nextLine().toUpperCase().trim();
        }

        System.out.println("Enter a valid recipe link for instructions");

        String instructions = scanner.nextLine();
        if (instructions.contains("https")) {
            DBInteractionRecipePicker.insertData(RecipeName, breakfast, lunch, dinner, winter, spring, summer, autumn, instructions);
        } else {
            System.out.println("Your link should contain 'https://'");
            instructions = scanner.nextLine();
            DBInteractionRecipePicker.insertData(RecipeName, breakfast, lunch, dinner, winter, spring, summer, autumn, instructions);
        }
    }
}
