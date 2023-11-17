package Algorithms;

/**
 * Implementation of the binary search algorithm to find a target value in a sorted array.
 */
public class binarySearch {

    /**
     * Starts the binary search by calling the recursive function with the following parameters:
     *
     * @param arr    The array to search in.
     * @param target The value to search for.
     */
    public static void binarySearchSort(int[] arr, int target) {
        binarySearchSort(arr, target, 0, arr.length - 1);
    }

    /**
     * Performs the binary search recursively within the specified range of the array.
     *
     * @param arr    The array to search in.
     * @param target The value to search for.
     * @param left   The starting index of the search range.
     * @param right  The ending index of the search range.
     */
    private static void binarySearchSort(int[] arr, int left, int right, int target) {
        // Check if the left index is less than or equal to the right index.
        while (left <= right) {
            // Calculate the middle index of the current search range.
            int middleIndex = left + (right - left) / 2;

            // Check if the target value is present at the middle index.
            if (arr[middleIndex] == target) {
                // Target value found, exit the function.
                return;
            }

            // If the target value is greater, ignore the left half.
            if (arr[middleIndex] < target) {
                left = middleIndex + 1;
            } else {
                // If the target value is smaller, ignore the right half.
                right = middleIndex - 1;
            }
        }

        // If we reach here, then the element was not present in the array.
    }
}