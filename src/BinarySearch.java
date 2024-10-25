/*
 * Created on 2024-10-16 
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

public class BinarySearch {

    public static int searchForCat(Cat[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            //check if the key matches the age of the cat at index mid
            if (array[mid].getAge() == key) {
                return mid;
            } else if (array[mid].getAge() < key) {
                left = mid + 1; //ignore left half
            } else {
                right = mid - 1; //ignore right half
            }
        }

        //if no match is found
        System.out.println("No cat found with age = " + key);
        return -1;
    }
}
