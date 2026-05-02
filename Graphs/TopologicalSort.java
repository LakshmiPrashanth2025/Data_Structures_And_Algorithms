import java.util.*;

public class TopologicalSort {

    // Inner class to represent the graph
    class Graph {
        int V; // Number of vertices
        List<Integer>[] adj; // Adjacency list

        // Constructor
        public Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        // Function to add an edge to the graph
        public void addEdge(int u, int v) {
            adj[u].add(v);
        }
    }

    // Topological Sort method in the outer class
    public void topologicalSort(Graph g) {
        int[] indegree = new int[g.V];

        // Compute indegree of each vertex
        for (int i = 0; i < g.V; i++) {
            for (int node : g.adj[i]) {
                indegree[node]++;
            }
        }

        // Queue for vertices with 0 indegree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < g.V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int cnt = 0;
        List<Integer> topOrder = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            topOrder.add(u);

            for (int node : g.adj[u]) {
                if (--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }

        // Check for cycle
        if (cnt != g.V) {
            System.out.println("There exists a cycle in the graph");
            return;
        }

        // Print topological order
        for (int i : topOrder) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();
        Graph g = ts.new Graph(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological Sort:");
        ts.topologicalSort(g);
    }
}
