package algorithm.greedyAlgorithm;

import java.util.ArrayList;

public class ActivitySelection {
    public static String RECURSIVE = "recursive";
    public static String ITERATIVE = "iterative";

    public static void main(String[] args) {
        // input - 2 arrays
        // start array denotes start time of activity
        // finish array denotes finish time of activity in sorted manner corresponding start array start.length = finish.length
        // if finish array is not sorted, sort it in O(n lg n) time (along with corresponding index of start array)
        int[] start = new int[] {1,3,0,5,3,5,6,8,8,2,12};
        int[] finish = new int[] {4,5,6,7,9,9,10,11,12,14,16};

        // function call
        activitySelectionCall(start, finish, RECURSIVE);
        activitySelectionCall(start, finish, ITERATIVE);
    }

    public static void activitySelectionCall(int[] start, int[] finish, String function) {
        ArrayList<Integer> solution;
        // function call
        if (function == RECURSIVE) {
            solution = new ArrayList<Integer>();
            activitySelectionWithRecursion(start, finish, 0, start.length, solution);
        } else {
            solution = activitySelectionIterative(start, finish);
        }

        // validation
        System.out.println("Approach: " + function + "; Solution: " + solution);
    }

    /**
     * Given function performs activity selection to maximize activities for the resources
     *
     * @param start
     *          array containing start time of activities such as start[i] is start time of activity i.
     * @param finish
     *          array containing finish time of activities such as finish[i] is start time of activity i.
     * @param k
     *          last activity we have added in solution set
     * @param n
     *          size of array
     * @param solution
     *          Array List containing solution
     */
    private static void activitySelectionWithRecursion(int[] start, int[] finish, int k, int n, ArrayList<Integer> solution) {
        int m = k + 1;
        while (m < n && start[m] < finish[k]) {     // if m starts before k, skip
            m++;
        }
        if (m < n) {
            if (k == 0) {                           // don't forget to add first activity
                solution.add(k);
            }
            solution.add(m);
            activitySelectionWithRecursion(start, finish, m, n, solution);
        }
    }

    private static ArrayList<Integer> activitySelectionIterative(int[] start, int[] finish) {
        ArrayList<Integer> solution = new ArrayList<Integer>();
        int n = start.length;

        // add first element in the list
        solution.add(0);
        int prevActivity = 0;

        for (int i = 1; i < n; i++) {
            // if i starts after previously added activity, add it in the solution,
            // and make i as new prevActivity
            if (start[i] >= finish[prevActivity]) {
                solution.add(i);
                prevActivity = i;
            }
        }
        return solution;
    }
}
