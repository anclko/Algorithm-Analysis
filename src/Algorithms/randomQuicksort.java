package Algorithms;


import java.util.Random;

public class randomQuicksort {
    public static void quickSortRandomIterative(int[] array) {
        int low = 0;
        int high = array.length - 1;

        int[] stack = new int[high - low + 1];
        int top = -1;

        stack[++top] = low;
        stack[++top] = high;

        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];

            int pivotIndex = partitionRandomPivot(array, low, high);

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

    // QuickSort with recursive approach and Random pivot
    public static void quickSortRandomRecursive(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionRandomPivot(array, low, high);

            quickSortRandomRecursive(array, low, pivotIndex - 1);
            quickSortRandomRecursive(array, pivotIndex + 1, high);
        }
    }

    // Swap method
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static final Random random = new Random(42);

    public static int partitionRandomPivot(int[] array, int low, int high) {
        int randomIndex = random.nextInt(high - low + 1) + low;
        swap(array, randomIndex, high);
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
}
