package Algorithms;

public class insertionIterative {

    public static void insertionSort(int[] array) {
        //initialize n to length of array
        int n = array.length;

        //go through the array starting from the second element
        for (int i = 1; i < n; i++) {
            //sets the index to the left of the current element.
            int j = i - 1;
            //store current element to be inserted into the sorted part of the array.
            int key = array[i];

            //moves elements greater than key to the right for insertion space.
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            // Insert key to correct position in the sorted array.
            array[j + 1] = key;
        }
    }
}
