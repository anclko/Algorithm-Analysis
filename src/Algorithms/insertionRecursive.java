package Algorithms;

public class insertionRecursive {
    public static void insertionSortRecursive(int[] arr, int i, int n) {
        int value = arr[i];
        int j = i;

        // find index `j` within the sorted subset `arr[0…i-1]`
        // where element `arr[i]` belongs
        while (j > 0 && arr[j - 1] > value) {
            arr[j] = arr[j - 1];
            j--;
        }

        arr[j] = value;

        // note that the subarray `arr[j…i-1]` is shifted to
        // the right by one position, i.e., `arr[j+1…i]`

        if (i + 1 <= n) {
            insertionSortRecursive(arr, i + 1, n);
        }
    }
}
