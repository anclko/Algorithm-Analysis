package Algorithms;

public class medianIterative {
    static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        if (arr[low] > arr[mid]) {
            int temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;
        }

        if (arr[low] > arr[high]) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }

        if (arr[mid] > arr[high]) {
            int temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp;
        }

        return mid;
    }

    static int partition(int[] arr, int low, int high) {
        // Choose the median of three elements as the pivot
        int pivotIndex = medianOfThree(arr, low, high);
        int pivot = arr[pivotIndex];

        // Swap the pivot element with the last element
        int temp = arr[high];
        arr[high] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Iterative quicksort function with median of three pivot
    public static void quickSortMedianIterative(int[] arr, int l, int h) {
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
}
