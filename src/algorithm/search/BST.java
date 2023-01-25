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
