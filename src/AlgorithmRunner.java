import Algorithms.*;
import Helpers.ResultFormatter;
import Helpers.WarmUp;

import java.util.Arrays;
import java.util.List;

public class AlgorithmRunner {
    public static void runAlgorithm(String algorithm, List<Integer> numbers, int numberOfRuns, int size, int numberOfElementsToShow) {

        // Run warm-up (for system stabilisation to avoid false times)
        int warmupIterations = 5;
        WarmUp.warmUp(numbers, algorithm, warmupIterations);

        // Running the program 10 times after warm up
        long totalElapsedTime = 0;

        int[] array = new int[0];
        int[] arrayForBinarySearch = new int[0];
        int resultIndex = -1;

        for (int run = 0; run < numberOfRuns; run++) {
            // Create a list to store the numbers
            array = numbers.stream().mapToInt(Integer::intValue).toArray();
            // Create copy for Binary Search algorithm
            arrayForBinarySearch = Arrays.copyOf(array, array.length);
            // Sort the list for Binary search algorithm only
            Arrays.sort(arrayForBinarySearch);

            // start countdown
            long startTime = System.nanoTime();

            // Call algorithms to run
            switch (algorithm) {
                case "Insertion Iterative":
                    insertionIterative.insertionSort(array);
                    break;
                case "Insertion Recursive":
                    insertionRecursive.insertionSortRecursive(array, 1, array.length - 1);
                    break;
                case "QS Random Pivot Iterative":
                    randomIterative.quickSortRandomIterative(array, 0, array.length - 1);
                    break;
                case "QS Random Pivot Recursive":
                    randomRecursive.quickSortRandomRecursive(array, 0, array.length - 1);
                    break;
                case "QS Array[0] Pivot Iterative":
                    firstElementIterative.quickSortIterative(array, 0, array.length - 1);
                    break;
                case "QS Array[0] Pivot Recursive":
                    firstElementRecursive.quickSortRecursive(array, 0, array.length - 1);
                    break;
                case "QS Median Pivot Iterative":
                    medianIterative.quickSortMedianIterative(array, 0, array.length - 1);
                    break;
                case "QS Median Pivot Recursive":
                    medianRecursive.quickSortMedianRecursive(array, 0, array.length - 1);
                    break;
                case "Binary Search":
                    resultIndex = binarySearch.binarySearchSort(arrayForBinarySearch, 49, 0, arrayForBinarySearch.length -1);
            }

            // Measure the end time
            long endTime = System.nanoTime();

            //end time calculated to nanoseconds
            totalElapsedTime += (endTime - startTime);

        }

        // average time calculation
        double averageElapsedTimeMicro = (double) (totalElapsedTime / numberOfRuns)/1000;
        double averageElapsedTimeMs = averageElapsedTimeMicro/1000;

        // print results in formatted way
        if ("Binary Search".equals(algorithm)) {
            ResultFormatter.printResults(algorithm, size, averageElapsedTimeMs, arrayForBinarySearch, numberOfElementsToShow);
            if (resultIndex != -1) {
                System.out.println("Target value found.");
            } else {
                System.out.println("Target value not found in the array.");
            }
        } else {
            ResultFormatter.printResults(algorithm, size, averageElapsedTimeMs, array, numberOfElementsToShow);
        }
    }
}

