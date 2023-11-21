package Algorithms;

public class insertionRecursive {
    public static void insertionSortRecursive(int[] arr, int i, int n) {
        int value = arr[i];
        int j = i;
        
        while (j > 0 && arr[j - 1] > value) {
            arr[j] = arr[j - 1];
            j--;
        }

        arr[j] = value;
        
        if (i + 1 <= n) {
            insertionSortRecursive(arr, i + 1, n);
        }
    }
}
