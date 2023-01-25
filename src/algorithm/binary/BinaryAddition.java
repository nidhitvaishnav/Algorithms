package algorithm.binary;

import java.util.Arrays;

public class BinaryAddition {
    public static void main(String args[]) {
        int[] a = new int[]{1, 0, 1, 0};
        int[] b = new int[]{1, 1, 1, 1};

        int[] ans = binaryAdditionCall(a, b);
        System.out.println("answer: " + Arrays.toString(ans));
    }

    private static int[] binaryAdditionCall(int[] a, int[] b) {
        int[] ans;
        if (a.length == b.length) {
            ans = new int[a.length+1];
        } else if (a.length > b.length) {
            ans = new int[a.length + 1];
        } else {
            ans = new int[b.length + 1];
        }

        int carry = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            ans[i+1] = (a[i] + b[i] + carry) % 2;
            if (a[i] + b[i] + carry >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
        }
        ans[0] = carry;
        return ans;
    }
}
