package Algorithms;

import java.util.Stack;

public class firstElementIterative {
    public static void firstIterative(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            int pivotIndex = partition(arr, low, high);

            // If there are elements on the left side of the pivot, push them to the stack
            if (pivotIndex - 1 > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }

            // If there are elements on the right side of the pivot, push them to the stack
            if (pivotIndex + 1 < high) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }

    // Partition function with the first element as pivot
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1, j = high;

        while (i <= j) {
            // Increment i while the element at arr[i] is less than the pivot
            while (i <= j && arr[i] <= pivot) {
                i++;
            }

            // Decrement j while the element at arr[j] is greater than the pivot
            while (arr[j] > pivot) {
                j--;
            }

            // If there are elements to swap, do the swap
            if (i <= j) {
                swap(arr, i, j);
            }
        }

        // Swap the pivot element with the element at index j
        swap(arr, low, j);

        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
