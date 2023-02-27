package algorithm.graph;

public class Graph {
    Node[] adj;

    public Graph(int size) {
        this.adj = new Node[size];
        for (int i = 0; i < size; i++) {
            this.adj[i] = new Node();
        }
    }

    /**
     * This method adds edge between G(u,v)
     *
     * @param u
     *          starting node u
     * @param v
     *          end node v
     */
    public void addEdge(int u, int v) {
        Node node = new Node();
        if (u >= this.adj.length || v >= this.adj.length) {
            System.out.println("Vertex name is not acceptable by graph as size is larger than graph size");
            return;
        }
        node.value = v;
        Node vertex = this.adj[u];
        while (vertex.next != null) {
            vertex = vertex.next;
        }
        vertex.next = node;
    }

    /**
     * Given method traverse the graph using breadth first search in O(V + E) time
     *
     * @param source
     *          source node from where we want to perform traversal of the graph
     */
    public void bfs (int source) {
        boolean[] visited = new boolean[this.adj.length];
        Node start = new Node();
        start.value = source;
        visited[source] = true;
        Node end = start;

        while (start != null) {
            // 1. mark start node as visited, print it
            System.out.print(start.value + " ");

            // 2. traverse through all of its adjacent nodes, and
            // if they are not visited, add them to the queue
            Node edge = this.adj[start.value].next;
            while (edge != null) {
                if (!visited[edge.value]) {
                    end.next = edge;
                    end = edge;
                    visited[edge.value] = true;
                }
                edge = edge.next;
            }

            // 3. dequeue the node as it is processed
            start = start.next;
        }
    }

    /**
     * Given method traverse the graph using depth first search in O(V + E) time
     *
     * @param source
     *          source node from where we want to perform traversal of the graph
     */
    public void dfs(int source) {
        boolean[] visited = new boolean[this.adj.length];
        dfsTraverse(source, visited);
    }

    private void dfsTraverse(int source, boolean[] visited) {
        // mark given node as visited
        visited[source] = true;
        System.out.print("(" + source + " ");

        // for given node, find all of its adjacent nodes and if they are not visited, visit them
        Node node = this.adj[source];
        while (node.next != null) {
            node = node.next;
            int edgeVal = node.value;
            if (!visited[edgeVal]) {
                dfsTraverse(edgeVal, visited);
            }
        }
        System.out.print(")");
    }
}