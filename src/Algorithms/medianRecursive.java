package Algorithms;

public class medianRecursive {
    public static void medianRec(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = medianOfThree(arr, low, high);
            int pivotFinalIndex = partition(arr, low, high, pivotIndex);

            // Check if pivotFinalIndex is within bounds
            if (pivotFinalIndex > low && pivotFinalIndex < high) {
                // Recursive call on the left of pivot
                medianRec(arr, low, pivotFinalIndex - 1);

                // Recursive call on the right of pivot
                medianRec(arr, pivotFinalIndex + 1, high);
            }
        }
    }

    public static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        // Sort the indices to find the median
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }

        // The median of three is now at the midIndex
        return mid;
    }

    public static int partition(int[] arr, int low, int high, int pivotIndex) {
        // Choose the pivot as the median of three
        int pivot = arr[pivotIndex];

        // Swap the pivot element with the last element
        swap(arr, pivotIndex, high - 1);

        int i = low - 1;
        int j = high - 1;

        while (true) {
            // Find element on the left that should be on the right
            do {
                i++;
            } while (arr[i] < pivot);

            // Find element on the right that should be on the left
            do {
                j--;
            } while (arr[j] > pivot);

            // If the indices have not crossed, swap elements
            if (i < j) {
                swap(arr, i, j);
            } else {
                // Indices have crossed, swap pivot to its correct place
                swap(arr, i, high - 1);
                return i;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
