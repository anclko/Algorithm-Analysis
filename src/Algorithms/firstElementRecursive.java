package Algorithms;

public class firstElementRecursive {
    public static void quickSortRecursive(int[] arr, int start, int stop) {
        if (start < stop) {
            // pi is the partitioning index, arr[pi] is now at the right place
            int partitionIndex = partition(arr, start, stop);

            // Recursively sort elements before and after the partition
            quickSortRecursive(arr, start, partitionIndex);
            quickSortRecursive(arr, partitionIndex + 1, stop);
        }
    }

    static int partition(int[] arr, int low, int high) {
        // Choose the first element as the pivot
        int pivot = arr[low];

        // Move pivot to the correct position
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Swap the pivot to its final position
        swap(arr, i, low);

        // Return the index of the pivot
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
