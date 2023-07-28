import java.util.*;
public class Main {
    // DFS Based Solution
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean vis[], int parent){
        vis[src] = true;
        
        for(int nbr : adj.get(src)){
            if(vis[nbr] == false){
                if(dfs(adj, nbr, vis, src))
                   return true;
            }
            else if(nbr != parent){
                return true;
            }
        }
        return false;
    }
    // BFS Based Solution
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                if(dfs(adj, i, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }
}
