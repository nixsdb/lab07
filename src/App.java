/*
 * Created on 2024-10-16
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;

public class App {

    private static Scanner myScanner = new Scanner(System.in);
    private static boolean readDataFromFile = false;

    public static void main(String[] args) {
        // Print the first input argument
        System.out.println("Reading: " + Arrays.toString(args));
        // Check the argument's length
        if (args.length > 0) {
            Cat[] cats = readCatsFromFile(args[0]);

            if (cats != null) {
                //sort the cats by age using quicksort
                QuickSort.sort(cats, 0, cats.length - 1);
                printCats(cats);

                // Search for a key
                int key = 10; // age
                System.out.println("Searching for: age = " + key);
                int i = BinarySearch.searchForCat(cats, key);

                if (i != -1) {
                    System.out.println("Found cat at index " + i + ": " + cats[i] + "!");
                }
            }
        }
        myScanner.close();
    }

    public static void printCats(Cat[] cats) {
        System.out.println("Sorted cats:");
        for (int i = 0; i < cats.length; i++) {
            System.out.println("Cat " + (i+1) + ": " + cats[i]);
        }
    }

    /*
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * ! NO NEED TO TOUCH THE LINES BELOW !
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */

    public static Cat[] readCatsFromFile(String fileName) {
        // A FileNotFoundException could occur when reading a file
        // The try-catch block ould also be around the method invocation in main!
        try {
            readDataFromFile = true;
            File file = new File(fileName);
            myScanner = new Scanner(file);

            // Count all lines in the file
            int lineCount = 0;
            while (myScanner.hasNextLine()) {
                myScanner.nextLine();
                lineCount++;
            }
            // The txt file allocates 6 lines to one cat
            int numberOfCats = lineCount / 6;

            // Reinitialize scanner
            myScanner = new Scanner(file);

            Cat[] cats = new Cat[numberOfCats];
            for (int i = 0; i < cats.length && myScanner.hasNextLine(); i++) {
                Cat cat = readCatFromInput();
                cats[i] = cat;
                System.out.println((i + 1) + ". cat: " + cat.getName());
            }
            System.out.printf("Read %d cats%n%n", cats.length);

            return cats;

        } catch (FileNotFoundException e) {
            System.out.println("Could not find file; " + e);

            return null;
        }
    }

    // Read cat object from user input
    public static Cat readCatFromInput() {
        // System.out.println("\n------Reading a new cat------");

        Owner owner = promptForOwner();
        Cat userCat = promptForCat();

        if (userCat != null) {
            userCat.setOwner(owner);
            if (promptForStory()) {
                String story = promptForStoryDetails();
                userCat.setFunnyStory(story);
            }
        }
        // System.out.println("-----------------------------");

        return userCat;
    }

    public static void printCatInfo(Cat cat) {
        System.out.println();
        if (cat != null && cat.getOwner() != null) {
            System.out.print(cat.getOwner().getName() + " has adopted " + cat.getName());
            if (cat.getAge() != 404) {
                System.out.print(" (" + cat.getAge() + ")");
            }
            if (cat.getFunnyStory() != "" && !(cat.getFunnyStory().equals("n/a"))) {
                System.out.println(" and shared this story: ");
                System.out.println(cat.getFunnyStory().toString());
            } else {
                System.out.println(".");
            }
        }
    }

    // Helper methods to prompt the user for input
    private static Owner promptForOwner() {
        String ownerName = myScanner.nextLine();
        // System.out.println("Owner:\t\t" + ownerName);
        return new Owner(ownerName);
    }

    private static Cat promptForCat() {
        String name = myScanner.nextLine();
        // System.out.println("Cat name:\t" + name);

        String catSound = myScanner.nextLine();
        // System.out.println("Cat sound:\t" + catSound);

        boolean isValidNumber = false;
        int age = 404; // Error code
        while (!isValidNumber) {
            try {
                age = myScanner.nextInt();
                isValidNumber = true;
            } catch (InputMismatchException e) {
                if (!readDataFromFile) {
                    System.out.println("Invalid input. Please enter a number.");
                } else {
                    isValidNumber = true;
                }
            }
            myScanner.nextLine();
        }
        // System.out.println("Cat age:\t" + age);
        return new Cat(name, age, catSound);
    }

    private static String promptForStoryDetails() {
        // System.out.print("Story title:\t");
        String storyTitle = myScanner.nextLine();
        // System.out.println(storyTitle);
        // System.out.print("Story:\t\t");
        String storyDescription = myScanner.nextLine();
        // System.out.println(storyDescription);

        if (!storyTitle.isEmpty()) {
            storyTitle = storyTitle.concat(" - ");
        }
        return storyTitle.concat(storyDescription);
    }

    private static boolean promptForStory() {
        if (readDataFromFile) {
            return true;
        }
        System.out.println("Do you want to share a funny story about your cat? (yes/no)");
        String response = myScanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }
}
