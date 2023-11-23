package Algorithms;

import java.util.Stack;

public class medianIterative {

    public static void medianIter(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if (low < high) {
                int pivotIndex = medianOfThree(arr, low, high);
                int pivotFinalIndex = partition(arr, low, high, pivotIndex);

                // Push sub-arrays to the stack for later processing
                stack.push(low);
                stack.push(pivotFinalIndex - 1);
                stack.push(pivotFinalIndex + 1);
                stack.push(high);
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
