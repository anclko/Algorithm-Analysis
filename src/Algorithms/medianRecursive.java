package Algorithms;

public class medianRecursive {
    static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }

        return mid;
    }

    static int partition(int[] arr, int low, int high) {
        int pivotIndex = medianOfThree(arr, low, high);
        int pivot = arr[pivotIndex];

        // Swap the pivot with the last element
        swap(arr, pivotIndex, high);

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

    // Recursive quicksort function with median of three pivot
    public static void quickSortMedianRecursive(int[] arr, int low, int high) {
        if (low < high) {
            // Set pivot element at its correct position in the sorted array
            int p = partition(arr, low, high);

            // Recursively sort elements before and after the partition
            quickSortMedianRecursive(arr, low, p - 1);
            quickSortMedianRecursive(arr, p + 1, high);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
