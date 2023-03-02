package algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 *
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 */

public class shortestBridgeBetweenTwoIslands {
    public static void main(String[] args) {
        // input
        int[][] grid = {{0,1}, {1,0}};

        // method call
        int steps = shortestBridge(grid);

        // output
        System.out.println(steps + " zeroes are required to convert into 1 in order to find the shortest bridge between 2 islands");
    }

    public static int shortestBridge(int[][] grid) {
        // initialization
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid.length];

        // find first island
        findFirstIsland(grid, visited, queue);

        // find the shortest distance to second island (unvisited 1) from first island using bfs
        return findStepsToBuildShortestBridgeToSecondIsland(grid, visited, queue);
    }

    /** find first island using dfs - time complexity: O(n^2)  as we go through entire n*n grid*/
    private static void findFirstIsland(int[][] grid, boolean[][] visited, Queue<int[]> queue) {
        boolean isFirstIslandFound = false;
        for (int i = 0; i < grid.length && !isFirstIslandFound; i++) {
            for (int j = 0; j < grid.length && !isFirstIslandFound; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, queue, i, j);
                    isFirstIslandFound = true;
                }
            }
        }
    }

    private static void dfs(int[][] grid, boolean[][] visited, Queue<int[]> queue, int row, int col) {
        if (!isCoordinatesInGrid(row, col, grid.length)
                || visited[row][col]
                || grid[row][col] == 0) {
            return;
        }
        visited[row][col] = true;
        queue.add(new int[]{row, col});
        dfs(grid, visited, queue, row + 1, col);
        dfs(grid, visited, queue, row - 1, col);
        dfs(grid, visited, queue, row, col + 1);
        dfs(grid, visited, queue, row, col - 1);

    }

    private static int findStepsToBuildShortestBridgeToSecondIsland(int[][] grid,boolean[][] visited, Queue<int[]> queue) {
        int steps = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] coordinates = queue.poll();
                for (int[] dir : directions) {
                    int x = coordinates[0] + dir[0];
                    int y = coordinates[1] + dir[1];
                    if (isCoordinatesInGrid(x, y, grid.length) && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            return steps;
                        }
                        visited[x][y] = true;
                        queue.add(new int[]{x,y});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private static boolean isCoordinatesInGrid(int row, int col, int n) {
        if (row < 0 || row >= n ||
                col < 0 || col >= n) {
            return false;
        }
        return true;
    }
}
