package Algorithms;

public class medianRecursive {
    static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        if (arr[low] > arr[mid]) {
            int temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;
        }

        if (arr[low] > arr[high]) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }

        if (arr[mid] > arr[high]) {
            int temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp;
        }

        return mid;
    }

    static int partition(int[] arr, int low, int high) {
        // Choose the pivot using the median of three
        int pivotIndex = medianOfThree(arr, low, high);
        int pivot = arr[pivotIndex];

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

    public static void quickSortMedianRecursive(int[] arr, int low, int high) {
        if (low < high) {
            // pi is the partitioning index, arr[pi] is now at the right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after the partition
            quickSortMedianRecursive(arr, low, pi - 1);
            quickSortMedianRecursive(arr, pi + 1, high);
        }
    }
}
