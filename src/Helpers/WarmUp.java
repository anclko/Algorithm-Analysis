package Helpers;

import Algorithms.*;

import java.util.List;
import java.util.Random;

public class WarmUp {

    public static void warmUp(List<Integer> numbers, String algorithm, int warmupIterations) {
        for (int warmup = 0; warmup < warmupIterations; warmup++) {
            int[] array = numbers.stream().mapToInt(Integer::intValue).toArray();

            // Call the appropriate sorting method based on the algorithm
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
                    medianRecursive.quickSortMedianRecursive(array, 0, array.length -1);
                    break;
                case "Binary Search":
                    //choosing and setting random number to choose
                    int targetIndex = new Random().nextInt(array.length);
                    int target = array[targetIndex];
                    //System.out.println("Searching for target: " + target);
                    binarySearch.binarySearchSort(array, target);
                    break;
                // Add cases for other algorithms
            }
        }
    }
}
