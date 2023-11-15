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

        for (int run = 0; run < numberOfRuns; run++) {

            // Create a list to store the numbers
            array = numbers.stream().mapToInt(Integer::intValue).toArray();
            // Create copy for Binary Search algorithm
            arrayForBinarySearch = Arrays.copyOf(array, array.length);
            Arrays.sort(arrayForBinarySearch);

            // start countdown
            long startTime = System.nanoTime();

            // Call algorithms to run
            switch (algorithm) {
                case "Insertion Iterative":
                    insertionIterative.insertionSort(array);
                    break;
                case "Insertion Recursive":
                    insertionRecursive.insertionSortRecursive(array, array.length);
                    break;
                case "QS Random Pivot Iterative":
                    randomIterative.quickSortRandomIterative(array, 0, array.length - 1);
                    break;
                case "QS Random Pivot Recursion":
                    randomRecursive.quickSortRandomRecursive(array, 0, array.length - 1);
                    break;
                case "QS Array[0] Pivot Iterative":
                    firstElementIterative.quickSortIterative(array, 0, array.length - 1);
                    break;
                case "QS Array[0] Pivot Recursive":
                    firstElementRecursive.quickSortRecursive(array, 0, array.length - 1);
                    break;
                case "QS Median Iterative":
                    medianIterative.quickSortMedianIterative(array, 0, array.length - 1);
                    break;
                case "QS Median Recursive":
                    medianRecursive.quickSortMedianRecursive(array, 0, array.length - 1);
                    break;
                case "Binary Search":
                    // Choosing and setting a fixed middle number
                    int targetIndex = arrayForBinarySearch.length / 2;
                    int target = arrayForBinarySearch[targetIndex];
                    // Binary search
                    binarySearch.binarySearchSort(arrayForBinarySearch, target);
                    break;
            }

            // Measure the end time
            long endTime = System.nanoTime();

            //end time calculated from nano to microseconds
            totalElapsedTime += (endTime - startTime) / 1000;

        }

        // average time calculation
        double averageElapsedTime = (double) totalElapsedTime / numberOfRuns;

        // print results in formatted way
        if ("Binary Search".equals(algorithm)) {
            ResultFormatter.printResults(algorithm, size, averageElapsedTime, arrayForBinarySearch, numberOfElementsToShow);
        } else {
            ResultFormatter.printResults(algorithm, size, averageElapsedTime, array, numberOfElementsToShow);
        }
    }
}

