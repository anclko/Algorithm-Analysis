package Algorithms;

import java.util.Random;

public class randomIterative {

    public static void quickSortRandomIterative(int[] arr, int l, int h) {
        // Create an auxiliary stack
        int[] stack = new int[h - l + 1];

        // initialize top of stack
        int top = -1;

        // push initial values of l and h to stack
        stack[++top] = l;
        stack[++top] = h;

        // Keep popping from stack while it is not empty
        while (top >= 0) {
            // Pop h and l
            h = stack[top--];
            l = stack[top--];

            // Set pivot element at its correct position in the sorted array
            int p = partition(arr, l, h);

            // If there are elements on the left side of the pivot, push left side to stack
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            // If there are elements on the right side of the pivot, push right side to stack
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }

    static int partition(int[] arr, int low, int high) {
        // Choose a random pivot index
        int pivotIndex = low + new Random().nextInt(high - low + 1);
        int pivot = arr[pivotIndex];

        // Swap the pivot with the element at the high index
        swap(arr, pivotIndex, high);

        int i = low;

        // Iterate through the array and rearrange elements based on the pivot
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        // Move the pivot to its final position
        swap(arr, i, high);

        // Return the index of the pivot element
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
