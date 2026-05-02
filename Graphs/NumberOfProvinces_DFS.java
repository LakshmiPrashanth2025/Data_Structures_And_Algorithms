
public class NumberOfProvinces_DFS {

    public static int findProvinces(int[][] adj, int V) {
        boolean[] visited = new boolean[V];
        int provinceCount = 0;

        for (int i = 0; i < V; i++) {
            
            if (!visited[i]) 
            {
                dfs(i, adj, visited, V);
                provinceCount++;
            }
        }

        return provinceCount;
    }

    private static void dfs(int node, int[][] adj, boolean[] visited, int V) {
        visited[node] = true;
        for (int j = 0; j < V; j++) {
            if (adj[node][j] == 1 && !visited[j]) {
                dfs(j, adj, visited, V);
            }
        }
    }

    public static void main(String[] args) {
        int[][] adj = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        int V = 3;

        int numProvinces = findProvinces(adj, V);
        System.out.println("Number of provinces: " + numProvinces);
    }
}

