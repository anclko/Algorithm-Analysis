package Algorithms;

public class firstElementRecursive {
    public static void firstRecursive(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = array0Pivot(arr, low, high);
            pivotIndex = partition(arr, low, high, pivotIndex);
            firstRecursive(arr, low, pivotIndex - 1);
            firstRecursive(arr, pivotIndex + 1, high);
        }
    }

    private static int array0Pivot(int[] arr, int low, int high) {
        return high; // Use high as the pivot index
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
