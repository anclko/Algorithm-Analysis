package Algorithms;


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

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        // Swap the pivot to its final position
        swap(arr, i, high);

        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
