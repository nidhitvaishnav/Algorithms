package algorithm.search;

import java.util.Arrays;

public class BST {
    public static void main(String[] args) {
        int[] input = {1,3,5,7,10,15,16,20,21};

        System.out.println("input array: " + Arrays.toString(input));

        int val = 20;
        int searchIndex = binarySearchTree(input, 0, input.length - 1, val);

        if (searchIndex == -1) {
            System.out.println("Searched value " + val + " is not found.");
        } else {
            System.out.println("Searched value " + val + " is found at index: " + searchIndex);
        }
    }

    /**
     * Given function finds a value from a sorted array in O(lg n) using binary search tree.
     * Here, we check mid-value, if it is answer, we return the index.
     * If val is smaller, we search left of the tree. Otherwise,  we search right of the tree
     * If we do not find the answer, we return -1 as index
     *
     * @param arr
     *          integer array
     * @param firstIndex
     *          first index of the tree
     * @param lastIndex
     *          last index of the tree
     * @param val
     *          search value
     *
     * @return
     *          Index of the array if search value is found, else -1
     */
    private static int binarySearchTree(final int[] arr, int firstIndex, int lastIndex, final int val) {
        while (firstIndex <= lastIndex) {
            int mid = (firstIndex + lastIndex) / 2;
            if (arr[mid] == val) {
                return mid;
            } else if (val < arr[mid]) {
                lastIndex = mid - 1;
            } else {
                firstIndex = mid + 1;
            }
        }
        return -1;
    }
}
