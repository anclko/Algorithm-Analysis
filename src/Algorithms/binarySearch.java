package Algorithms;

public class binarySearch {

    public static int binarySearchSort(int[] numbers, int numberToFind, int low, int high) {

        if (numbers == null || low > high) {
            return -1; // Invalid input or element not found
        }

        int middlePosition = low + (high - low) / 2;
        int middleNumber = numbers[middlePosition];

        if (numberToFind == middleNumber) {
            return middlePosition;
        } else if (numberToFind < middleNumber) {
            return binarySearchSort(numbers, numberToFind, low, middlePosition - 1);
        } else {
            return binarySearchSort(numbers, numberToFind, middlePosition + 1, high);
        }
    }
}
