package Helpers;

public class ResultFormatter {
    public static void printResults(String algorithm, int size, double averageTime, int[] sortedArray, int numberOfElementsToShow) {
        System.out.printf("%-30s %-20d %-30.3f ", algorithm, size, averageTime);

        // Call the printSortedArray method to display a few elements from the sorted array
        ArrayPrinted.printSortedArray(sortedArray, numberOfElementsToShow);

        // Print a newline to move to the next row
        System.out.println();
    }

    public static void printTableHeader() {
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.printf("%-30s %-20s %-30s %-30s%n", "Algorithm", "Size of Input", "Average Time (nanoseconds)", "Array Printed");
        System.out.println("------------------------------------------------------------------------------------------------------");
    }
}
