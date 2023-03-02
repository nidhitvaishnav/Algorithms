package algorithm.graph;

import java.util.Queue;
import java.util.LinkedList;

public class GraphMetrics {
    int[][] graph;
    int size;

    public GraphMetrics(int size) {
        graph = new int[size][size];
        this.size = size;
    }

    public void addEdge(int u, int v) {
        if (!isNodeValid(u)) {
            System.out.println("Can not add the edge as node " + u + " is invalid");
            return;
        }
        if (!isNodeValid(v)) {
            System.out.println("Can not add the edge as node " + v + " is invalid");
            return;
        }
        this.graph[u][v] = 1;
    }

    public void bfs(int source) {
        if (!isNodeValid(source)) {
            return;
        }
        boolean[] visited = new boolean[this.size];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < this.size; i++) {
                if (this.graph[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
            System.out.print(" " + node);
        }
    }

    public void dfs(int source) {
        boolean[] visited = new boolean[this.size];

        dfsSearch(source, visited);
    }

    private void dfsSearch(int source, boolean[] visited) {
        if (!isNodeValid(source)) {
            return;
        }
        visited[source] = true;
        System.out.print(" " + source);
        for(int i = 0; i < this.size; i++) {
            if (this.graph[source][i] == 1 && !visited[i]) {
                dfsSearch(i, visited);
            }
        }
    }

    public boolean isNodeValid(int node) {
        if (node < 0 || node > this.size) {
            return false;
        }
        return true;
    }
}
