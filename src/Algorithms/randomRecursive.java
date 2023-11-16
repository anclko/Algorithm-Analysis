package Algorithms;

import java.util.Random;

public class randomRecursive {
    static int randomPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }
    static int partition(int[] arr, int low, int high) {
        int randomIndex = randomPivot(low, high);

        // Swap the random pivot with the last element to simplify the loop logic
        int temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;

        int pivot = arr[high];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j)
                return j;

            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
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
