package Algorithms;

public class binarySearch {
    public static void binarySearchSort(int[] arr, int target) {
        //initialise start and end
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            //initialise mid variable
            int mid = start + (end- start) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return;
            }

            // If target is greater, ignore the left half
            if (arr[mid] < target) {
                start = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                end = mid - 1;
            }
        }

    }
}