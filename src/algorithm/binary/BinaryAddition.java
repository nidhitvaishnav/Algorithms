package algorithm.binary;

import java.util.Arrays;

public class BinaryAddition {
    public static void main(String args[]) {
        int[] a = new int[]{1};
        int[] b = new int[]{1, 0, 1};

        int[] ans = binaryAdditionCall(a, b);
        System.out.println("answer: " + Arrays.toString(ans));
    }

    /**
     * Method that calls binary addition with larger array as first input and smaller array as second input
     *
     * @param a
     *      integer array containing binary values
     * @param b
     *      integer array containing binary values
     *
     * @return
     *      result of binary addition in an integer array
     */
    private static int[] binaryAdditionCall(int[] a, int[] b) {
        if (a.length >= b.length) {
            return binaryAddition(a, b);
        } else {
            return binaryAddition(b, a);
        }
    }

    /**
     * This function returns binary addition with O(n) time complexity.
     *
     * @param a
     *      larger integer array containing binary values
     * @param b
     *      smaller integer array containing binary values
     *
     * @return
     *      result of binary addition in an integer array
     */
    private static int[] binaryAddition(int[] a, int[] b) {
        int maxLen = a.length;
        int[] ans = new int[maxLen + 1];

        int carry = 0;
        // As we know b is shorter array, perform binary addition up to b.length
        for (int i = b.length - 1; i >= 0; i--) {
            ans[i+1] = (a[i] + b[i] + carry) % 2;
            carry = (a[i] + b[i] + carry) / 2;
        }
        // At this point we have added value of b with a. And now array b is 0.
        // So add array a with carry.
        for (int i = a.length - b.length; i >= 0; i--) {
            ans[i+1] = (a[i] + carry) % 2;
            carry = (a[i] + carry) / 2;
        }
        // Don't forget to append last carry
        ans[0] = carry;

        return ans;
    }
}
