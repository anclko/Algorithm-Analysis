package Algorithms;

public class firstElementIterative {
        // Function to partition the array and return the partition index
        static int partition(int[] arr, int low, int high) {
            // Choose the first element as the pivot
            int pivot = arr[low];

            // Swap the first element with the last element
            int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;

            // index of smaller element
            int i = low - 1;

            for (int j = low; j <= high - 1; j++) {
                // If the current element is smaller than or equal to the pivot
                if (arr[j] <= pivot) {
                    i++;

                    // Swap arr[i] and arr[j]
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

        // Iterative quicksort function
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
    }