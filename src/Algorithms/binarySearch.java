package Algorithms;

public class binarySearch {
    public static void binarySearchSort(int[] arr, int target) {
        binarySearchSort(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchSort(int[] arr, int target, int start, int end) {
        if (start <= end) {
            //set up a mid-value on sorted list
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                //search the right side
                return binarySearchSort(arr, target, mid + 1, end);
            } else {
                //search the left side
                return binarySearchSort(arr, target, start, mid - 1);
            }
        }
        //when element not found
        return -1;
    }
}