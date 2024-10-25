/*
 * Created on 2024-10-16 
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

public class MergeSort {

    // Main function that sorts array[l..r] using merge()
    static void sort(Cat array[], int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            sort(array, left, mid);
            sort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Merges two subarrays of array[].
    // Sub-array left: array[l..m]
    // Sub-array right: array[m+1..r]
    private static void merge(Cat array[], int left, int mid, int right) {
        int leftElementLength = mid - left + 1;
        int rightElementLength = right - mid;

        // Define sub-arrays
        Cat leftSubArray[] = new Cat[leftElementLength];
        Cat rightSubArray[] = new Cat[rightElementLength];

        // Copy data to sub-arrays arrays
        for (int i = 0; i < leftElementLength; ++i) {
            leftSubArray[i] = array[left + i];
        }
        for (int j = 0; j < rightElementLength; ++j) {
            rightSubArray[j] = array[mid + 1 + j];
        }

        /* Merge the sub-arrays arrays */
        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftElementLength && j < rightElementLength) {
            if (leftSubArray[i].getAge() <= rightSubArray[j].getAge()) {
                array[k] = leftSubArray[i];
                i++;
            } else {
                array[k] = rightSubArray[j];
                j++;
            }
            k++;
        }

        // Handle remaining elements that have not yet been added to the main array:
        while (i < leftElementLength) {
            array[k] = leftSubArray[i];
            i++;
            k++;
        }
        while (j < rightElementLength) {
            array[k] = rightSubArray[j];
            j++;
            k++;
        }
    }
}
