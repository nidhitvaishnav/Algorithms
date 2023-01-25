package algorithm.divideAndConquer;

public class MaximumSubarray {
    public static void main(String[] args) {
        findMaximumSubArrayCall();
        findMaximumSubArrayDevideAndConquerCall();
    }

    private static void findMaximumSubArrayDevideAndConquerCall() {
        // input
        int [] input = getInputArr();

        int[] diffArr = new int[input.length -1];
        for (int i = 0; i <input.length - 1; i++) {
            diffArr[i] = input[i + 1] - input[i];
        }

        // method call
        int[] output = findMaximumSubArrayDevideAndConquer(diffArr, 0, diffArr.length - 1);

        // validate
        System.out.println("To maximize the profit to " + output[2] + " user should buy on " + (output[0])
                + "th day and sell on " + (output[1] + 1) + "th day.");
    }


    private static int[] findMaximumSubArrayDevideAndConquer(int[] array, int low, int high) {
        if (low == high) {
            return new int[]{low, high, array[low]};
        }
        int mid = (low + high)/2;
        int[] leftAns = findMaximumSubArrayDevideAndConquer(array, low, mid);
        int[] rightAns = findMaximumSubArrayDevideAndConquer(array, mid + 1, high);
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
