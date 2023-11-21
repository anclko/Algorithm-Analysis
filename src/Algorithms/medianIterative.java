package Algorithms;

public class medianIterative {

    public static void medianIter(int[] array) {
        int low = 0;
        int high = array.length - 1;

        int[] stack = new int[high - low + 1];
        int top = -1;

        stack[++top] = low;
        stack[++top] = high;

        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];

            int pivotIndex = partitionMedianOfThree(array, low, high);

            if (pivotIndex - 1 > low) {
                stack[++top] = low;
                stack[++top] = pivotIndex - 1;
            }

            if (pivotIndex + 1 < high) {
                stack[++top] = pivotIndex + 1;
                stack[++top] = high;
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Lomuto partition method
    public static int partitionLomuto(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    // Partition method using Median of Three pivot
    public static int partitionMedianOfThree(int[] array, int low, int high) {
        int mid = low + (high - low) / 2;

        // Sort low, mid, and high to determine the median
        if (array[low] > array[mid]) {
            swap(array, low, mid);
        }

        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }

        if (array[low] > array[mid]) {
            swap(array, low, mid);
        }

        // Place the pivot at the end before partitioning
        swap(array, mid, high - 1);
        return partitionLomuto(array, low, high - 1);
    }
}
