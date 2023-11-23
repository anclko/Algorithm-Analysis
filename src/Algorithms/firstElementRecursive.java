package Algorithms;

public class firstElementRecursive {
    // method to find the partition position
    public static void firstRecursive(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the index of the pivot element
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the subarrays on either side of the pivot
            firstRecursive(arr, low, pivotIndex);
            firstRecursive(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1, j = high + 1;

        while (true) {
            // Increment i while the element at arr[i] is less than the pivot
            do {
                i++;
            } while (arr[i] < pivot);

            // Decrement j while the element at arr[j] is greater than the pivot
            do {
                j--;
            } while (arr[j] > pivot);

            // If there are zero or one elements in the subarray, then it is already sorted
            if (i >= j) {
                return j;
            }

            // Swap arr[i] and arr[j] to put them in the correct order
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
