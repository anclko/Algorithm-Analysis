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

        // Time Set Up For Each Algorithm:
        long totalInsertionIter= 0;
        long totalInsertionRec = 0;
        long totalRandomIter = 0;
        long totalRandomRec = 0;
        long totalMedianIter = 0;
        long totalMedianRec = 0;
        long totalArr0Iter = 0;
        long totalArr0Rec = 0;
        long totalBinary = 0;
        long totalBinary2 = 0;

        // Average Time Algorithm
        double averageII = 0;
        double averageIR = 0;
        double averageRI = 0;
        double averageRR = 0;
        double averageMI = 0;
        double averageMR = 0;
        double averageFI = 0;
        double averageFR = 0;
        double averageB = 0;
        double averageB2 = 0;

        int[] array = new int[0];
        int[] arrayForBinarySearch = new int[0];
        int resultIndex = -1;
        int resultIndex2 = -1;

        for (int run = 0; run < numberOfRuns; run++) {
            // Create a list to store the numbers
            array = numbers.stream().mapToInt(Integer::intValue).toArray();
            // Create copy for Binary Search algorithm
            arrayForBinarySearch = Arrays.copyOf(array, array.length);
            // Sort the list for Binary search algorithm only
            Arrays.sort(arrayForBinarySearch);

            // Call algorithms to run
            switch (algorithm) {
                case "Insertion Iterative":
                    long startII = System.nanoTime();
                    insertionIterative.insertionSort(array);
                    long endTimeII = System.nanoTime();
                    totalInsertionIter += (endTimeII - startII);
                    averageII = (double) (totalInsertionIter / numberOfRuns) /1000;
                    break;
                case "Insertion Recursive":
                    long startIR = System.nanoTime();
                    insertionRecursive.insertionSortRecursive(array, 1, array.length - 1);
                    long endIR = System.nanoTime();
                    totalInsertionRec += (endIR - startIR);
                    averageIR = (double) (totalInsertionRec / numberOfRuns)/1000;
                    break;
                case "QS Random Pivot Iterative":
                    long startRI = System.nanoTime();
                    randomQuicksort.quickSortRandomIterative(array);
                    long endRI = System.nanoTime();
                    totalRandomIter += (endRI - startRI);
                    averageRI = (double) (totalRandomIter/ numberOfRuns)/1000;
                    break;
                case "QS Random Pivot Recursive":
                    long startRR = System.nanoTime();
                    randomQuicksort.quickSortRandomRecursive(array, 0, array.length - 1);
                    long endRR = System.nanoTime();
                    totalRandomRec += (endRR - startRR);
                    averageRR = (double) (totalRandomRec/ numberOfRuns)/1000;
                    break;
                case "QS Array[0] Pivot Iterative":
                    long startFI = System.nanoTime();
                    firstElementIterative.firstIterative(array);
                    long endFI = System.nanoTime();
                    totalArr0Iter += (endFI - startFI);
                    averageFI = (double) (totalArr0Iter/ numberOfRuns)/1000;
                    break;
                case "QS Array[0] Pivot Recursive":
                    long startFR = System.nanoTime();
                    firstElementRecursive.firstRecursive(array, 0, array.length - 1);
                    long endFR = System.nanoTime();
                    totalArr0Rec += (endFR - startFR);
                    averageFR = (double) (totalArr0Rec/ numberOfRuns)/1000;
                    break;
                case "QS Median Pivot Iterative":
                    long startMI = System.nanoTime();
                    medianIterative.medianIter(array);
                    long endMI = System.nanoTime();
                    totalMedianIter += (endMI - startMI);
                    averageMI = (double) (totalMedianIter/ numberOfRuns)/1000;
                    break;
                case "QS Median Pivot Recursive":
                    long startMR = System.nanoTime();
                    medianRecursive.medianRec(array, 0, array.length - 1);
                    long endMR = System.nanoTime();
                    totalMedianRec += (endMR - startMR);
                    averageMR = (double) (totalMedianRec/ numberOfRuns)/1000;
                    break;
                case "Binary Search":
                    long startB = System.nanoTime();
                    resultIndex = binarySearch.binarySearchSort(arrayForBinarySearch, 80, 0, arrayForBinarySearch.length - 1);
                    long endB = System.nanoTime();
                    totalBinary += (endB - startB);
                    averageB = (double) (totalBinary/ numberOfRuns)/1000;

                    long startB2 = System.nanoTime();
                    resultIndex2 = binarySearch.binarySearchSort(arrayForBinarySearch, 120, 0, arrayForBinarySearch.length - 1);
                    long endB2 = System.nanoTime();
                    totalBinary2 += (endB2 - startB2);
                    averageB2 = (double) (totalBinary2/ numberOfRuns)/1000;

            }
        }

        // print results in formatted way
        if ("Binary Search".equals(algorithm)) {
            ResultFormatter.printResults(algorithm, size, averageB, arrayForBinarySearch, numberOfElementsToShow);
            if (resultIndex != -1) {
                System.out.println("Target found at index: " + resultIndex);
            } else {
                System.out.println("Target not found");
            }
        }
        if ("Binary Search".equals(algorithm)) {
            ResultFormatter.printResults(algorithm, size, averageB2, arrayForBinarySearch, numberOfElementsToShow);
            if (resultIndex2 != -1) {
                System.out.println("Target found at index: " + resultIndex);
            } else {
                System.out.println("Target not found");
            }
        }
        if ("Insertion Iterative".equals(algorithm)) {
            ResultFormatter.printResults(algorithm, size, averageII, array, numberOfElementsToShow);
        }
        if ("Insertion Recursive".equals(algorithm)) {
            ResultFormatter.printResults(algorithm, size, averageIR, array, numberOfElementsToShow);
        }
        if ("QS Random Pivot Iterative".equals(algorithm)) {
            ResultFormatter.printResults(algorithm, size, averageRI, array, numberOfElementsToShow);
        }
        if ("QS Random Pivot Recursive".equals(algorithm)) {
            ResultFormatter.printResults(algorithm, size, averageRR, array, numberOfElementsToShow);
        }
        if ("QS Array[0] Pivot Iterative".equals(algorithm)) {
            ResultFormatter.printResults(algorithm, size, averageFI, array, numberOfElementsToShow);
        }
        if ("QS Array[0] Pivot Recursive".equals(algorithm)) {
            ResultFormatter.printResults(algorithm, size, averageFR, array, numberOfElementsToShow);
        }
        if ("QS Median Pivot Iterative".equals(algorithm)) {
            ResultFormatter.printResults(algorithm, size, averageMI, array, numberOfElementsToShow);
        }
        if ("QS Median Pivot Recursive".equals(algorithm)) {
            ResultFormatter.printResults(algorithm, size, averageMR, array, numberOfElementsToShow);
        }
    }
}

