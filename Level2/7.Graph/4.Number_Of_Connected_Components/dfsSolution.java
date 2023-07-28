import java.util.*;

class Solution {
    public static void bfs(ArrayList<ArrayList<Integer>> adj, int V, int src, boolean vis[]) {

        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        vis[src] = true;

        while (q.size() > 0) {
            int vt = q.remove();
            // System.out.print(vt + " ");

            for (int e : adj.get(vt)) {
                if (!vis[e]) {
                    q.add(e);
                    vis[e] = true;
                }
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            adjList.add(new ArrayList<>());
        }

        //convert into adjacancy list
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                }
            }
        }
        int count = 0;
        boolean vis[] = new boolean[V];

        // Then simply call the function for all not visited Nodes
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                bfs(adjList, V, i, vis);
                count++;
            }
        }
        return count;
    }
};