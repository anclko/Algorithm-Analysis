package Helpers;

public class ArrayPrinted {

    public static void printSortedArray(int[] sortedArray, int numberOfElementsToShow) {
        int elementsToShow = Math.min(numberOfElementsToShow, sortedArray.length);
        for (int i = 0; i < elementsToShow; i++) {
            System.out.print(sortedArray[i] + ",");
        }
    }
}
