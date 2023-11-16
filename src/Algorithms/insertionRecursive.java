package Algorithms;
/**
 * Implementation of insertion sort algorithm using recursive method.
 */
public class insertionRecursive {
    /**
     * Sorts an array using insertion sort recursively.
     *
     * @param arr  The array to be sorted.
     * @param size The size of the array.
     */
    public static void insertionSortRecursive(int[] arr, int size) {
        // base case -> if the size is 0 or less, the array is sorted
        if (size <= 0)
            return;

        //recursive call to sort the array with one less element
        insertionSortRecursive(arr, size - 1);

        //insertion of last element into the sorted portion of the array
        int key = arr[size - 1];
        int j = size - 2;

        //shift elements greater than key to the right to make space for insertion
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        //insert the key to correct position in the array
        arr[j + 1] = key;
    }
}
