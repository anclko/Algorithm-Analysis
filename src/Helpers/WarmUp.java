package Helpers;

import Algorithms.*;
import java.util.Arrays;
import java.util.List;

public class WarmUp {

    public static void warmUp(List<Integer> numbers, String algorithm, int warmupIterations) {

        int[] arrayForBinarySearch;

        for (int warmup = 0; warmup < warmupIterations; warmup++) {

            int[] array = numbers.stream().mapToInt(Integer::intValue).toArray();

            // Create copy for Binary Search algorithm
            arrayForBinarySearch = Arrays.copyOf(array, array.length);
            Arrays.sort(arrayForBinarySearch);

            // Call the appropriate sorting method based on the algorithm
            switch (algorithm) {
                case "Insertion Iterative":
                    insertionIterative.insertionSort(array);
                    break;
                case "Insertion Recursive":
                    insertionRecursive.insertionSortRecursive(array, 1, array.length -1);
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
                case "QS Median Pivot Iterative":
                    medianIterative.quickSortMedianIterative(array, 0, array.length - 1);
                    break;
                case "QS Median Pivot Recursive":
                    medianRecursive.quickSortMedianRecursive(array, 0, array.length - 1);
                    break;
                case "Binary Search":
                    binarySearch.binarySearchSort(arrayForBinarySearch, 49, 0, arrayForBinarySearch.length -1);
                    break;
            }
        }
    }
}
