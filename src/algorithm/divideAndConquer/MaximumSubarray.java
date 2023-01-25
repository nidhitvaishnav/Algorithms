package algorithm.divideAndConquer;

public class MaximumSubarray {
    public static void main(String[] args) {
        findMaximumSubArrayCall();
        findMaximumSubArrayDivideAndConquerCall();
    }

    private static void findMaximumSubArrayDivideAndConquerCall() {
        // input
        int [] input = getInputArr();

        int[] diffArr = new int[input.length -1];
        for (int i = 0; i <input.length - 1; i++) {
            diffArr[i] = input[i + 1] - input[i];
        }

        // method call
        int[] output = findMaximumSubArrayDivideAndConquer(diffArr, 0, diffArr.length - 1);

        // validate
        System.out.println("To maximize the profit to " + output[2] + " user should buy on " + (output[0])
                + "th day and sell on " + (output[1] + 1) + "th day.");
    }


    /**
     * This solution is to find the maximum subarray using divide and conquer approach
     * which completes the algo in O(n lg n) time complexity.
     * In this method, we recursively divide array in left and right,and find the maximum array.
     * Then we call crossing subArray O(n) method to find crossing max array.
     * At the end we choose max value out of all of them.
     *
     *  @param array
     *          integer diff array (diff Array: input[i+1] - input[i]
     * @param low
     *          lower index
     * @param high
     *          higher index
     *
     * @return integer output Array of size 3
     *          output[0] = left index such that we find max sub array
     *          output[1] = right index such that we find max sub array
     *          output[2] = maximum sum value for max sub array
     */
    private static int[] findMaximumSubArrayDivideAndConquer(int[] array, int low, int high) {
        if (low == high) {
            return new int[]{low, high, array[low]};
        }
        int mid = (low + high)/2;
        int[] leftAns = findMaximumSubArrayDivideAndConquer(array, low, mid);
        int[] rightAns = findMaximumSubArrayDivideAndConquer(array, mid + 1, high);
        int[] crossingAns = findMaximumCrossingSubArray(array, low, mid, high);
        if ((leftAns[2] >= rightAns[2]) && (leftAns[2] >= crossingAns[2])) {
            return leftAns;
        } else if ((rightAns[2] >= leftAns[2]) && rightAns[2] >= crossingAns[2]) {
            return rightAns;
        }
        else {
            return crossingAns;
        }
    }

    /**
     * This method find max crossing sub array with O(n) time complexity.
     * Initially we find maximum left sum from array[mid ... low] and store left index where sum is max
     * Than we find maximum right sum from array[mid+1 ... high] and store right index where sum is max
     * Than we return left index, right index and (leftSum + rightSum)
     * @param array
     *          integer diff array
     * @param low
     *          lower index
     * @param mid
     *          mid index
     * @param high
     *          higher index
     *
     * @return integer output array that contains,
     *          output[0] = left index
     *          output[1] = right index
     *          output[2] = left sum + right sum (max crossing sum)
     */
    private static int[] findMaximumCrossingSubArray(int[] array, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int leftIndex = low;
        for (int i = mid; i >= low ; i--) {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftIndex = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int rightIndex = mid + 1;
        for (int i = mid + 1; i <= high; i++) {
            sum += array[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightIndex = i;
            }
        }
        return new int[] {leftIndex, rightIndex, leftSum + rightSum};
    }


    private static void findMaximumSubArrayCall() {
        // input
        int [] input = getInputArr();

        // method call
        int[] output = findMaximumSubArrayBruteForce(input);

        // validate
        System.out.println("To maximize the profit to " + output[2] + " user should buy on " + (output[0])
                + "th day and sell on " + (output[1]) + "th day.");
    }

    /**
     * This solution is to find maximum sub array using brute force with O(n^2) time complexity
     * from given start index, find the sum to all next indexes,
     * for the pair of start and end index that gives largest sum is the answer
     * @param input int array
     * @return start index and end index
     */
    private static int[] findMaximumSubArrayBruteForce(int[] input) {
        int[] output = new int[3];
        int firstIndex = -1;
        int lastIndex = -1;
        int sum = 0;
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                int diff = input[j] - input[i];
                if (diff > sum) {
                    sum = diff;
                    firstIndex = i;
                    lastIndex = j;
                }
            }
        }
        output[0] = firstIndex;
        output[1] = lastIndex;
        output[2] = sum;
        return output;
    }

    private static int[] getInputArr() {
        int[] input = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        // int [] input = {100, 110, 113, 85};
        return input;
    }
}
