package Algorithms;

public class firstElementIterative {
    public static void quickSortIterative(int[] arr, int low, int high) {
        int[] stack = new int[high - low + 1];
        int top = -1;

        stack[++top] = low;
        stack[++top] = high;

        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];

            int pivotIndex = partition(arr, low, high);

            // If there are elements on the left side of the pivot, push left side to stack
            if (pivotIndex - 1 > low) {
                stack[++top] = low;
                stack[++top] = pivotIndex - 1;
            }

            // If there are elements on the right side of the pivot, push right side to stack
            if (pivotIndex + 1 < high) {
                stack[++top] = pivotIndex + 1;
                stack[++top] = high;
            }
        }
    }

    static int partition(int[] arr, int low, int high) {
        // Choose the first element as the pivot
        int pivot = arr[low];

        // Swap the pivot with the last element
        swap(arr, low, high);

        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        // Swap the pivot to its final position
        swap(arr, i, high);

        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}