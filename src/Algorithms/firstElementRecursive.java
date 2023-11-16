package Algorithms;

public class firstElementRecursive {
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            // Find the leftmost element greater than or equal to the pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // Find the rightmost element smaller than or equal to the pivot
            do {
                j--;
            } while (arr[j] > pivot);

            // If the two pointers met
            if (i >= j)
                return j;

            // Swap the elements at positions i and j
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void quickSortRecursive(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSortRecursive(arr, low, partitionIndex - 1);
            quickSortRecursive(arr, partitionIndex + 1, high);
        }
    }
}
