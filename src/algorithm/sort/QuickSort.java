package algorithm.sort;

import algorithm.utils.CommonUtils;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    private static CommonUtils COMMON_UTILS = new CommonUtils();
    private static String QUICK_SORT = "quick sort";
    private static String RANDOMIZED_QUICK_SORT = "randomized quick sort";
    public static void main(String[] args) {
        int[] arr = getInput();

        sort(QUICK_SORT, Arrays.copyOf(arr, arr.length));
        sort(RANDOMIZED_QUICK_SORT, Arrays.copyOf(arr, arr.length));

    }

    private static void sort(String sortType, int[] arr) {
        // input
        System.out.println("array before " + sortType + "  sort: " + Arrays.toString(arr));

        // method call
        if (sortType == QUICK_SORT) {
            quickSort(arr, 0, arr.length - 1);
        } else if (sortType == RANDOMIZED_QUICK_SORT) {
            randomizedQuickSort(arr, 0, arr.length - 1);
        }

        System.out.println("Arr after calling " + sortType + " sort: " + Arrays.toString(arr) + "\n");
    }

    /**
     * Given method sorts an input array using quick sort,
     * which has worst time complexity O(n^2) when array is sorted (worst partition)
     * and average time complexity O(n lg n) when array is random (best sorting algorithm)
     *
     * @param arr
     *          input array on which sort operation is being performed
     * @param l
     *          value of left index
     * @param r
     *          value of right index
     */
    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = partition(arr, l, r);
            quickSort(arr, l, mid - 1);
            quickSort(arr, mid + 1, r);
        }
    }

    /**
     * This algorithm performs partition for quick sort algorithm in O(n) time complexity
     *
     * @param arr
     *          input array on which partition operation is being performed
     * @param l
     *          value of left index
     * @param r
     *          value of right index
     * @return
     *          value of index where pivot is present at the end of the algorithm
     */
    private static int partition(int[] arr, int l, int r) {
        // logic for partition
        // set i at the left of l index and set pivot as r index
        int i = l - 1;
        int pivot = arr[r];
        //for all j in arr[l ... r] check if arr[j] < pivot,
        // if yes, increase i and swap values of arr[i] and arr[j]
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                COMMON_UTILS.swap(arr, i, j);
            }
        }
        // finally swap the value of arr[r] (pivot) with arr[i+1] to position pivot correctly such that,
        // arr[l ... i] < pivot; arr [i + 1] == pivot ; and arr [i + 2 ... r] > pivot
        COMMON_UTILS.swap(arr, i + 1, r);
        return i + 1;
    }


    /**
     * Given method sorts an input array using  randomized quick sort,
     * Benefit of this algo over quick sort is that if array is sorted (worst time complexity of quick sort), than also
     * due to randomization this algorithm would have time complexity of O(n lg n).
     *
     * @param arr
     *          input array on which sort operation is being performed
     * @param l
     *          value of left index
     * @param r
     *          value of right index
     */
    private static void randomizedQuickSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = randomizedPartition(arr, l, r);
            randomizedQuickSort(arr, l, mid - 1);
            randomizedQuickSort(arr, mid + 1, r);
        }
    }

    /**
     * This method is called before calling partition() of quick sort in order to randomize mid index
     * such that partitions are at random even if array is sorted (where quick sort gives worst time complexity).
     *
     * @param arr
     *          input array on which sort operation is being performed
     * @param l
     *          value of left index
     * @param r
     *          value of right index
     *
     * @return index
     *          value of index where pivot is present at the end of the algorithm
     */
    private static int randomizedPartition(int[] arr, int l, int r) {
        Random random = new Random();
        int mid = random.ints(l, r + 1).findFirst().getAsInt();
        COMMON_UTILS.swap(arr, mid, r);
        return partition(arr, l, r);
    }


    private static int[] getInput() {
        return new int[]{5,2,4,1,6,3};
    }
}
