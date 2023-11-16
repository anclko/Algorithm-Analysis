package Algorithms;

public class medianRecursive {

    public static void quickSortMedianRecursive(int[] arr, int low, int high) {
        if (low < high) {
            // pi is the partitioning index, arr[pi] is now at the right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after the partition
            quickSortMedianRecursive(arr, low, pi - 1);
            quickSortMedianRecursive(arr, pi + 1, high);
        }
    }
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
        // Choose the median of three elements as the pivot
        int pivotIndex = medianOfThree(arr, low, high);
        int pivot = arr[pivotIndex];

        // Swap the pivot element with the last element
        swap(arr, pivotIndex, high);

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        swap(arr, i + 1, high);

        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
