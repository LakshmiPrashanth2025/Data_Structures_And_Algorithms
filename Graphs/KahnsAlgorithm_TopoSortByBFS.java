import java.util.*;

class Graph {
    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public int getVertices() {
        return V;
    }

    public List<List<Integer>> getAdjList() {
        return adj;
    }
}


/* Main class using Kahn's Algorithm
 * Step 1: Compute Indegree of Each Node
 * Step 2: Enqueue All Nodes with Indegree 0 - Nodes with indegree 0 always appear earlier (towards the front) in the topological order.
 * Step 3: Process Queue to Build Topological Order
 * Step 4: Check for Cycles (Optional but Important)
 */
public class KahnsAlgorithm_TopoSortByBFS {

    /*
     * Step 1: Compute indegrees
     * Indegree of a vertex (or node) in a directed graph is the number of edges coming into that vertex
     */
    private static int[] computeIndegree(Graph graph) {
        int V = graph.getVertices();
        List<List<Integer>> adj = graph.getAdjList();
        int[] indegreeList = new int[V];

        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                indegreeList[v]++;
            }
        }
        return indegreeList;
    }

    // Step 2: Enqueue nodes with indegree 0
    private static Queue<Integer> initializeQueue(int[] indegreeList) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegreeList.length; i++) {
            if (indegreeList[i] == 0) {
                queue.offer(i);
            }
        }
        return queue;
    }

    /*
    * Step 3: Process queue and build topological order
    * Removes nodes with indegree 0 from the queue, as they are  independent 
    *  & are guaranteed to come before their neighbors in any valid topological order.
    *  Add them to the result,
    *  and update the indegree of their neighbors.
    */
    private static List<Integer> processQueue(Graph graph, int[] indegree, Queue<Integer> queue) {
        List<Integer> topoOrder = new ArrayList<>();
        List<List<Integer>> adj = graph.getAdjList();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);

            for (int v : adj.get(u)) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    // Move this node v to the end of the queue
                    queue.offer(v);
                }
            }
        }

        return topoOrder;
    }

    // Step 4: Validate and return result
    public static List<Integer> topologicalSort(Graph graph) {
        int[] indegree = computeIndegree(graph);                    // Step 1
        Queue<Integer> queue = initializeQueue(indegree);           // Step 2
        List<Integer> topoOrder = processQueue(graph, indegree, queue); // Step 3

        if (topoOrder.size() != graph.getVertices()) {              // Step 4
            throw new RuntimeException("Graph has a cycle – topological sort not possible");
        }

        return topoOrder;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        try {
            List<Integer> result = topologicalSort(graph);
            System.out.println("Topological Order: " + result);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
