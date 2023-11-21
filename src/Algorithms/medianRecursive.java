package Algorithms;

public class medianRecursive {
    public static void medianRec(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = medianOfThreePivot(arr, low, high);
            pivotIndex = partition(arr, low, high, pivotIndex);
            medianRec(arr, low, pivotIndex - 1);
            medianRec(arr, pivotIndex + 1, high);
        }
    }

    private static int medianOfThreePivot(int[] arr, int low, int high) {
        int middle = low + (high - low) / 2;
        if (arr[low] > arr[middle]) {
            swap(arr, low, middle);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[middle] > arr[high]) {
            swap(arr, middle, high);
        }

        // Move pivot to the end
        swap(arr, middle, high - 1);
        return high; // Use high - 1 as the pivot index
    }

    private static int partition(int[] arr, int low, int high, int pivotIndex) {
        int pivot = arr[pivotIndex];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
