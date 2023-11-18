package Algorithms;

public class binarySearch {

    public static int binarySearchSort(int[] numbers, int numberToFind, int low, int high) {

        if (high >= low && low <= numbers.length - 1) {
            int middlePosition = low + (high - low) / 2;
            int middleNumber = numbers[middlePosition];

            if (numberToFind == middleNumber){
                return middlePosition;
            }
            if (numberToFind < middleNumber){
                return binarySearchSort(numbers, numberToFind, low, middlePosition - 1);
            }
            else {
                return binarySearchSort(numbers, numberToFind, middlePosition + 1, high);
            }
        }
        return -1;
    }
}