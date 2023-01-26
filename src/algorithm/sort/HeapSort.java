package algorithm.sort;

import utils.CommonUtils;
import java.util.Arrays;

public class HeapSort {
    private static CommonUtils COMMON_UTILS = new CommonUtils();

    public static void main(String args[]) {
        int[] arr = {5, 2, 4, 7, 1, 3, 8};

        sort(Arrays.copyOf(arr, arr.length));
    }

    private static void sort(int[] arr) {
        System.out.println("Arr before calling heap sort: " + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Arr after calling heap sort: " + Arrays.toString(arr));
    }

    /**
     * Performs heap sort with time complexity of O(n lg n). It is a sort-in-place algorithm
     *
     * @param arr
     *      input array on which sorting is being performed
     */
    private static void heapSort(int[] arr) {
        // build max heap such that max value is on the root node (0th index)
        buildMaxHeap(arr);
        int heapSize = arr.length - 1;
        // for entire array,
        // 1. swap the root node (max value) with the last leaf node (last index),
        // 2. remove that leaf node (which now has max value of given heap) by reducing heapSize
        // 3. call maxHeapify on the root node (which now has leaf node value)
        for (int i = arr.length - 1; i > 0; i--) {
            COMMON_UTILS.swap(arr, i, 0);
            heapSize--;
            maxHeapify(arr, 0, heapSize);
        }
    }

    /**
     * Given method builds max heap such that  each parent node contains value larger than its leaf nodes. i.e.
     *       8
     *   7        5
     * 1   3     2   4
     *
     * @param arr
     *      input array on which sorting is being performed
     */
    private static void buildMaxHeap(int[] arr) {
        int heapSize = arr.length - 1;
        // all nodes with index larger than heapSize/2 are leaf nodes
        for (int i = (heapSize) / 2; i >= 0; i--) {
            maxHeapify(arr, i, heapSize);
        }
    }

    /**
     * Given method performs max heapify function recursively as long as child node is larger than parent node
     *
     * @param arr
     *      input array on which sorting is being performed
     * @param index
     *      index of (parent) node on which max heapify function is being performed
     * @param heapSize
     *      current heap size
     */
    private static void maxHeapify(int[] arr, final int index, final int heapSize) {
        // get left and right child nodes
        int leftIndex = getLeft(index);
        int rightIndex = getRight(index);
        // initialize maxValIndex which stores index of node with highest value amongst given node and its child nodes
        int maxValIndex = index;
        // check if value at left child is larger than the given node
        if (leftIndex <= heapSize && arr[leftIndex] > arr[index]) {
            maxValIndex = leftIndex;
        }
        // check if value at right child is larger than the node with highest value
        if (rightIndex <= heapSize && arr[rightIndex] > arr[maxValIndex]) {
            maxValIndex = rightIndex;
        }
        // if value at any child node is larger than the given node,
        // 1. swap values of given parent node with that child node and
        // 2. call maxHeapify() on that child node
        if (maxValIndex != index) {
            COMMON_UTILS.swap(arr, maxValIndex, index);
            maxHeapify(arr, maxValIndex, heapSize);
        }
    }

    private static int getParent(final int n) {
        return (n / 2) - 1;
    }

    private static int getLeft(final int n) {
        return (2 * n) + 1;
    }

    private static int getRight(final int n) {
        return (2 * n) + 2;
    }
}
