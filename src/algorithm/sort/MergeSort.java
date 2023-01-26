package algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // input
        int[] arr = {5,2,4,1,6,3};

        sort(Arrays.copyOf(arr, arr.length));
    }

    private static void sort(int[] arr) {
        System.out.println("array before merge sort: " + Arrays.toString(arr));

        // method call
        mergeSort(arr, 0, arr.length - 1);

        // output
        System.out.println("array after merge: " + Arrays.toString(arr));
    }

    /**
     * This method sorts array using merge sort, with time complexity O(n lg n).
     *
     * @param arr
     *          input array on which sorting is being performed
     * @param l
     *          value of left index
     * @param r
     *          value of right index
     */
    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    /**
     * This method perform merge operation (combine) after merge operation has divided the array into smaller problems.
     * Time complexity of this operation is O(n).
     *
     * @param arr
     *      input array on which merge operation is being performed
     * @param l
     *      value of left index
     * @param m
     *      value of left index
     * @param r
     *      value of mid index
     */
    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        // store arr[l ... m] in left array
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        // store arr[m+1 ... r] in right array
        for (int j = 0; j < n2; j++) {
            right[j] = arr[m + j + 1];
        }
        int i = 0, j = 0;
        int k = l;
        // store min(left[i], right[j]) into array[k] where k starts from l (left index),
        // until one array is exhausted.
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        // append remaining sorted array with arr
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
