package Algorithms;

import java.util.Random;

public class randomRecursive {
    public static void quickSortRandomRecursive(int[] arr, int start, int stop) {
        if (start < stop) {
            // pi is the partitioning index, arr[pi] is now at the right place
            int partitionIndex = partition(arr, start, stop);

            // Recursively sort elements before and after the partition
            quickSortRandomRecursive(arr, start, partitionIndex - 1);
            quickSortRandomRecursive(arr, partitionIndex + 1, stop);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        // Choose a random pivot index
        int pivotIndex = low + new Random().nextInt(high - low + 1);
        int pivot = arr[pivotIndex];

        // Move pivot to the end
        swap(arr, pivotIndex, high);

        // Initialize indices for the elements smaller and greater than the pivot
        int i = low - 1;

        // Iterate through the array and rearrange elements based on the pivot
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move the pivot to its final position
        swap(arr, i + 1, high);

        // Return the index of the pivot element
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
