package algorithm.metrics;

import algorithm.utils.MetricsUtils;

public class MetricsMultiplication {
    public static void main(String[] args) {
        MetricsUtils metricsUtils = new MetricsUtils();

        // input
//        int[][] m1 = new int[][]{{1, 0}, {0, 1}};
//        int[][] m2 = new int[][]{{1, 2}, {3, 4}};

//        int[][] m1 = new int[][]{{1, 1}, {1, 1}};
//        int[][] m2 = new int[][]{{1}, {2}};

        int[][] m1 = new int[][]{{1, 1}};
        int[][] m2 = new int[][]{{1, 2, 3}, {2, 3, 4}};

        metricsUtils.printMetrics(m1);
        metricsUtils.printMetrics(m2);
        int [][] ans;
        try {
            ans = metricsMultiplication(m1, m2);
            metricsUtils.printMetrics(ans);
        } catch (Exception e) {
        }
    }

    /**
     * Given method performs metrics multiplication using brute force with time complexity O(n^3).
     *
     * @param m1
     *      a 2D integer array containing m * n metrics
     * @param m2
     *      a 2D integer array containing n * o metrics
     * @return
     *      a 2D integer array containing m * o metrics
     * @throws Exception
     */
    private static int[][] metricsMultiplication(int[][] m1, int[][] m2) throws Exception {
        // throw exception if one of the metrics is empty
        if (m1.length==0 || m2.length == 0) {
            System.out.println("ERROR: Cannot perform metrics multiplication as one of the metrics is empty.");
            throw new Exception();
        }
        int m = m1.length;
        int n = m2.length;
        int o = m2[0].length;

        // if metrics does not follow M1 (m * n) and M2 (n * o) size, throw exception.
        if (m1[0].length != n) {
            System.out.println("ERROR: Size of metrics m1 and m2 are not compatible for metrics multiplication");
            throw new Exception();
        }

        // perform metrics multiplication
        int [][] ans = new int[m][o];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < o; j++) {
                ans[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    ans[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return ans;
    }
}