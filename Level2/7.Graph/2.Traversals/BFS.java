import java.util.*;

class GFG {
    // This is used to print the graph
    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.println(i + " is connected with " + adj.get(i).get(j));
            }
        }
    }

    // This function is used to add nodes in graph
    public static void add(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // -------------------GeeksforGeeks solution---------------------
    // public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean vis[] = new boolean[V];
        
    //     q.add(0);
    //     vis[0] = true;
        
    //     ArrayList<Integer> result = new ArrayList<>();
    //     while(q.size() > 0){
            
    //         int e = q.remove();
    //         result.add(e);
            
    //         for(int v : adj.get(e)){
    //             if(!vis[v]){
    //                 q.add(v);
    //                 vis[v] = true;
    //             }
    //         }
    //     }
    //     return result;
    // }

    // This is BFS traversal of graph
    public static void bfs(ArrayList<ArrayList<Integer>> adj, int v) {

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[v];

        q.add(0);
        visited[0] = true;

        while (q.size() > 0) {
            int vt = q.remove();
            System.out.println(vt);

            for (int e : adj.get(vt)) {
                if (!visited[e]) {
                    q.add(e);
                    visited[e] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        add(adj, 0, 1);
        add(adj, 0, 2);
        add(adj, 1, 3);
        add(adj, 2, 4);
        add(adj, 3, 5);
        add(adj, 4, 5);

        printGraph(adj);
        bfs(adj, v);
    }
}