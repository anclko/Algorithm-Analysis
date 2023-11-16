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
     * @param left  The starting index of the search range.
     * @param right    The ending index of the search range.
     * @return The index of the target if found, otherwise -1, not found.
     */
    private static int binarySearchSort(int[] arr, int target, int left, int right) {
        // checks if the left index is less than or equal to the right index.
        if (left <= right) {
            //set up a mid-value on sorted list
            int mid = left + (right - left) / 2;

            // checks if the value of middle index is equal to the target.
            if (arr[mid] == target) {
                return mid;
              //if target is greater than value at mid -> search right side
            } else if (arr[mid] < target) {
                return binarySearchSort(arr, target, mid + 1, right);
            } else {
                //otherwise -> search left
                return binarySearchSort(arr, target, left, mid - 1);
            }
        }
        //if start index greater than end, element is not found
        return -1;
    }
}