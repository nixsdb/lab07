/*
 * Created on 2024-10-16 
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

public class QuickSort {

    public static void sort(Cat[] array, int left, int right) {
        if (left < right) {
            // Partitioning index of current pivot element
            int partitioningIndex = partition(array, left, right);

            // Sort elements before partition and after partition
            // Preview: A method calling itself is called "recursion" (more about that soon!)
            sort(array, left, partitioningIndex - 1);
            sort(array, partitioningIndex + 1, right);
        }
    }

    private static int partition(Cat[] array, int left, int right) {
        //select the right-most element as pivot
        Cat pivot = array[right];

        int i = left - 1;
        // Reorder the array
        for (int j = left; j < right; j++) {
            if (array[j].getAge() <= pivot.getAge()) {
                i++;
                Cat temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        //place pivot in correct position
        Cat temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;

        // Returns the index of the pivot element
        return i + 1;
    }
}
