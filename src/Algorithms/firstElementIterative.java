package Algorithms;

public class firstElementIterative {
    // Function to partition the array and return the partition index
    public static void quickSortIterative(int[] arr, int l, int h) {
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

    public static int partition(int[] arr, int low, int high) {
        //first element chosen as pivot but for easier code implementation
        //moved the first element to the end
        swap(arr, low, high);
        int pivot = arr[high];

        int i = low - 1;
        int j = high;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                // Move the pivot to its final position
                swap(arr, i, high);
                return i;
            }

            swap(arr, i, j);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}