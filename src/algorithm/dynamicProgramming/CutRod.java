package algorithm.dynamicProgramming;

import java.util.Arrays;
public class CutRod {
    public static String RECURSIVE_APPROACH = "recursive approach";
    public static String MEMOIZED_APPROACH = "memoized approach";
    public static String TOP_DOWN_APPROACH = "top down approach";

    public static void main(String args[]) {
        // input
        int [] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 25};
//        int [] price = new int[]{1, 5, 8, 9};

        // function calls
        findCutRod(price, RECURSIVE_APPROACH);
        findCutRod(price, MEMOIZED_APPROACH);
        findCutRod(price, TOP_DOWN_APPROACH);
    }

    private static void findCutRod(int[] input, String function) {
        int maxPrice;
        if (function == RECURSIVE_APPROACH) {
            maxPrice = findMaxCutRodWithRecursion(input, input.length - 1, input.length);

        } else if (function == MEMOIZED_APPROACH) {
            maxPrice = findMaxCutRodWithMemoized(input, input.length - 1, input.length);
        } else {
            maxPrice = findCutRodTopDownApproach(input, input.length);
        }

        // validation
        System.out.println("Max price that can be achieved with " + function + " :" + maxPrice + "\n");
    }

    /**
     * Given function finds the maximum price that can be achieved after cutting rod of size n and with Price[] value
     * with O(2^n) time complexity recursively with devide and conquer approach.
     *
     * @param price
     *          array of price of rod at size (index + 1)
     * @param index
     *          array index
     * @param n
     *          size of rod
     *
     * @return
     *          max price of rod of size n
     */
    private static int findMaxCutRodWithRecursion(int[] price, int index, int n) {
        // n pieces of size 1
        if (index == 0) {
            return price[0]  * n;
        }
        // nonCut value, if you don't cut the road of size index
        int nonCutValue = findMaxCutRodWithRecursion(price, index - 1, n);

        // to find the value after cutting the rod, first assign cutValue as min,
        // assign rod length is index + 1 (index starts from 0)
        // as long as rod length is <=n, calculate new cut value with function
        // cutValue = p[i] + cutRod(p, i, n - rodLength)
        int cutValue = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if (rodLength <= n) {
            cutValue = price[index] + findMaxCutRodWithRecursion(price,index, n - rodLength);
        }
        // return max value
        return Math.max(nonCutValue, cutValue);
    }

    /**
     * Given function finds the maximum price that can be achieved after cutting rod of size n and with Price[] value
     * with O(n^2) time complexity recursively with dynamic recursive programming with stored data (storedPrice).
     *
     * @param price
     *          array of price of rod at size (index + 1)
     * @param index
     *          array index
     * @param n
     *          size of rod
     *
     * @return
     *          max price of rod of size n
     */
    private static int findMaxCutRodWithMemoized(int[] price, int index, int n) {
        // initialize stored price to minimum value
        int[] storedPrice = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            storedPrice[i] = Integer.MIN_VALUE;
        }
        // use the recursive approach, but if data is in storedPrice, use that value rather than re-calculating
        return findMaxCutRodWithMemoizedAux(price,storedPrice, n - 1, n);
    }


    /**
     * Same recursive function for cut rod as above, but if data is in storedPrice, use that value
     * rather than re-calculating it again
     *
     * @param price
     *          array of price of rod at size (index + 1)
     * @param storedPrice
     *          array of stored price, initially MIN_VALUE, but with calculation of sub problem we update this array
     * @param index
     *          array index
     * @param n
     *          size of rod
     *
     * @return
     *          max price of rod of size n
     */
    private static int findMaxCutRodWithMemoizedAux(int[] price, int[] storedPrice, int index, int n) {
        // if data is already stored, return stored value otherwise calcucate maxPrice using prev recursive approach
        if (storedPrice[index] != Integer.MIN_VALUE) {
            return storedPrice[index];
        }
        // n pieces of size 1
        if (index == 0) {
            return price[0] * n;
        }
        // nonCut value, if you don't cut the road of size index
        int nonCutValue = findMaxCutRodWithRecursion(price, index - 1, n);

        // to find the value after cutting the rod, first assign cutValue as min,
        // assign rod length is index + 1 (index starts from 0)
        // as long as rod length is <=n, calculate new cut value with function
        // cutValue = p[i] + cutRod(p, i, n - rodLength)
        int cutValue = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if (rodLength <= n) {
            cutValue = price[index] + findMaxCutRodWithRecursion(price,index, n - rodLength);
        }
        return Math.max(nonCutValue, cutValue);
    }

    /**
     * Given function finds the maximum price that can be achieved after cutting rod of size n and with Price[] value
     * with O(n^2) time complexity recursively with top-down dynamic programming approach.
     *
     * @param price
     *          array of price of rod at size (index + 1)
     * @param n
     *          size of rod
     *          
     * @return
     *          max price of rod of size n
     */
    private static int findCutRodTopDownApproach(int[] price, int n) {
        int[] maxPrice = new int[n + 1];
        int[] size = new int [n + 1];
        // base case, if rod length is 0, return 0
        maxPrice[0] = 0;
        // for each rod length, initialize max length with min value
        // for all subsequent rod cuts, compare the max value with price[j] + maxPrice[i - currentRodLength]
        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                int currentRodLength = j + 1;       // index starts from 0, so n=1 is at index 0
                if (maxVal < price[j] + maxPrice[i - currentRodLength]) {
                    maxVal = price[j] + maxPrice[i - currentRodLength];
                    size[i] = currentRodLength;
                }
            }
            maxPrice[i] = maxVal;
        }
        System.out.println("max Price at each length : " + Arrays.toString(maxPrice));
        printSizeOfRodCuttingTopDownForN(size, n);
        return maxPrice[n];
    }

    private static void printSizeOfRodCuttingTopDownForN(int[] size, int n) {
        while (n > 0) {
            System.out.println(size[n]);
            n = n - size[n];
        }
    }
}
