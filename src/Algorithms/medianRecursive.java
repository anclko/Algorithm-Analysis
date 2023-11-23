package Algorithms;


import java.util.Random;
import java.util.Stack;

public class randomQuicksort {

    private static final Random rand = new Random();

    public static void randomIterative(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if (low < high) {
                int pivotIndex = randomPivot(low, high);
                int pivotFinalIndex = partition(arr, low, high, pivotIndex);

                // Push sub-arrays to the stack for later processing
                if (pivotFinalIndex - 1 > low) {
                    stack.push(low);
                    stack.push(pivotFinalIndex - 1);
                }
                if (pivotFinalIndex + 1 < high) {
                    stack.push(pivotFinalIndex + 1);
                    stack.push(high);
                }
            }
        }
    }

    public static void randomRecursive(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = randomPivot(low, high);
            int pivotFinalIndex = partition(arr, low, high, pivotIndex);

            // Check if pivotFinalIndex is within bounds
            if (pivotFinalIndex > low && pivotFinalIndex < high) {
                // Recursive call on the left of pivot
                randomRecursive(arr, low, pivotFinalIndex - 1);

                // Recursive call on the right of pivot
                randomRecursive(arr, pivotFinalIndex + 1, high);
            }
        }
    }

    public static int randomPivot(int low, int high) {
        return rand.nextInt(high - low + 1) + low;
    }

    public static int partition(int[] arr, int low, int high, int pivotIndex) {
        // Choose the pivot as the randomly generated index
        int pivot = arr[pivotIndex];

        // Swap the pivot element with the last element
        swap(arr, pivotIndex, high);

        int i = low - 1;
        int j = high;

        while (true) {
            // Find element on the left that should be on the right
            do {
                i++;
            } while (arr[i] < pivot);

            // Find element on the right that should be on the left
            do {
                j--;
            } while (j > low && arr[j] > pivot);

            // If the indices have not crossed, swap elements
            if (i < j) {
                swap(arr, i, j);
            } else {
                // Indices have crossed, swap pivot to its correct place
                swap(arr, i, high);
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

