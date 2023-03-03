package algorithm.greedyAlgorithm.problems;

import java.util.ArrayList;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array
 * of the non-overlapping intervals that cover all the intervals in the input.
 *
 * intervals = [[1, 5], [3, 8], [5, 9], [10, 12]]
 * expected = [[1, 9], [10, 12]]
 */
public class FindIntervals {
    private static int START_TIME = 0;
    private static int END_TIME = 1;
    public static void main(String[] args) {
        // input
        int[][] intervals = {{1,5}, {3,8}, {5,6}, {5,9}, {10,12}, {11, 15}};

        // function call
        ArrayList<int[]> solution = mergeIntervals(intervals);

        // output
        for (int i = 0; i < solution.size(); i++) {
            System.out.println(solution.get(i)[START_TIME] + " " + solution.get(i)[END_TIME]);
        }
    }

    public static ArrayList<int[]> mergeIntervals(int[][] intervals) {
        ArrayList<int[]> solution = new ArrayList<>();

        if (intervals.length == 0) {
            return solution;
        }
        int start = intervals[0][START_TIME];
        int end = intervals[0][END_TIME];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][START_TIME] < end) {
                end = Math.max(intervals[i][END_TIME], end);
            } else {
                solution.add(new int[]{start, end});
                start = intervals[i][START_TIME];
                end = intervals[i][END_TIME];
            }
        }
        solution.add(new int[]{start, end});

        return solution;
    }
}
