package algorithm.graph.test;

import algorithm.graph.Graph;

public class TestGraph {

    public static void main(String args[]) {
        // create graph
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);

        System.out.print("BFS search: ");
        graph.bfs(2);

        System.out.print("\nDFS search: ");
        graph.dfs(2);
    }
}
