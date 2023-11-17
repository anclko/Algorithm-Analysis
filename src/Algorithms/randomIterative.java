package Algorithms;

import java.util.Random;

public class randomIterative {

    public static void quickSortRandomIterative(int[] arr, int low, int high) {
        // Create an auxiliary stack
        int[] stack = new int[high - low + 1];

        // initialize top of stack
        int top = -1;

        // push initial values of low and high to stack
        stack[++top] = low;
        stack[++top] = high;

        // Keep popping from stack while it is not empty
        while (top >= 0) {
            // Pop high and low
            high = stack[top--];
            low = stack[top--];

            // Set pivot element at its correct position in the sorted array
            int p = partition(arr, low, high);

            // If there are elements on the left side of the pivot, push left side to stack
            if (p - 1 > low) {
                stack[++top] = low;
                stack[++top] = p - 1;
            }

            // If there are elements on the right side of the pivot, push right side to stack
            if (p + 1 < high) {
                stack[++top] = p + 1;
                stack[++top] = high;
            }
        }
    }

    static int partition(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = low + rand.nextInt((high - low )+ 1);
        int pivot = arr[pivotIndex];

        // Swap the pivot with the last element
        swap(arr, pivotIndex, high);

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
