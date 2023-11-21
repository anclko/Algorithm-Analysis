package Algorithms;

public class firstElementIterative {
    public static void firstIterative(int[] array) {
        int low = 0;
        int high = array.length - 1;

        int[] stack = new int[high - low + 1];
        int top = -1;

        stack[++top] = low;
        stack[++top] = high;

        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];

            int pivotIndex = partitionArrayZeroPivot(array, low, high);

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

    public static int partitionArrayZeroPivot(int[] array, int low, int high) {
        // Place the pivot at the end before partitioning
        swap(array, low, high);
        return partition(array, low, high);
    }

    public static int partition(int[] array, int low, int high) {
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

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
