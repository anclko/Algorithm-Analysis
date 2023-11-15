package Algorithms;

public class insertionRecursive {
    public static void insertionSortRecursive(int[] arr, int size) {
        // Base case
        if (size <= 0)
            return;

        // Sort first n-1 elements
        insertionSortRecursive(arr, size - 1);

        // Insert last element at its correct position
        // in sorted array.
        int last = arr[size - 1];
        int j = size - 2;

        /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }
}
