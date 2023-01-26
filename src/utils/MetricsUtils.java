package utils;

public class MetricsUtils {
    public static void printMetrics(int[][] metrics) {
        for(int i = 0; i< metrics.length; i++) {
            for (int j = 0; j < metrics[i].length; j++) {
                System.out.print(metrics[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=========");
    }
}
