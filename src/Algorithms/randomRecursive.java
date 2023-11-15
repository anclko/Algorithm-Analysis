package Algorithms;

import java.util.Random;

public class randomRecursive {
    static int chooseRandomPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    static int partition(int[] arr, int low, int high) {
        // Choose a random pivot index within the range of the current array
        int pivotIndex = chooseRandomPivot(low, high);
        int pivot = arr[pivotIndex];

        // Swap the pivot element with the last element
        int temp = arr[high];
        arr[high] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void quickSortRandomRecursive(int[] arr, int low, int high) {
        if (low < high) {
            // pi is the partitioning index, arr[pi] is now at the right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after the partition
            quickSortRandomRecursive(arr, low, pi - 1);
            quickSortRandomRecursive(arr, pi + 1, high);
        }
    }
}
