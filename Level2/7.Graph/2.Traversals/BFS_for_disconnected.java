import java.util.*;
class GFG {

    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.println(i + " is connected with " + adj.get(i).get(j));
            }
        }
    }

    public static void add(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // ------------------BFS for disconnected graph------------------
    public static void bfs(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited, int sc) {

        Queue<Integer> q = new LinkedList<>();

        q.add(sc);
        visited[sc] = true;

        while (q.size() > 0) {
            int vt = q.remove();
            System.out.print(vt + " ");

            for (int e : adj.get(vt)) {
                if (!visited[e]) {
                    q.add(e);
                    visited[e] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 8;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        // disconnected graph
        // ----------first component---------
        add(adj, 0, 1);
        add(adj, 0, 2);
        add(adj, 1, 2);

        // ---------second component---------
        add(adj, 3, 4);

        // ---------third component---------
        add(adj, 5, 6);
        add(adj, 5, 7);
        add(adj, 6, 7);

        // printGraph(adj);
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                bfs(adj, v, visited, i);
            }
        }
    }
}