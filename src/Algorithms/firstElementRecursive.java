package Algorithms;

public class firstElementRecursive {
    public static void quickSortRecursive(int[] arr, int start, int stop) {
        if (start < stop) {
            // pi is the partitioning index, arr[pi] is now at the right place
            int partitionIndex = partition(arr, start, stop);

            // Recursively sort elements before and after the partition
            quickSortRecursive(arr, start, partitionIndex);
            quickSortRecursive(arr, partitionIndex + 1, stop);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        //first element chosen as pivot but for easier code implementation
        //moved the first element to the end
        swap(arr, low, high);
        int pivot = arr[high];

        int i = low - 1;
        int j = high;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                // Move the pivot to its final position
                swap(arr, i, high);
                return i;
            }

            swap(arr, i, j);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
