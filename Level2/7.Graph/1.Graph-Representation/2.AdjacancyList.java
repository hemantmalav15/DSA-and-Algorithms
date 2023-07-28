import java.util.*;

class AdjacancyList {
    
    public static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                System.out.println(i + " is connected with " + adj.get(i).get(j));
            }
        }
    }
    public static void add(ArrayList<ArrayList<Integer>> adj, int u, int v){
        // It means u is connected with v and 
        // v is connected with u 
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
	public static void main (String[] args) {
	    int v = 6;
	    
        // Create a List of Lists and add lists on its each idx
	    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	    for(int i = 0; i < v; i++){
	        adj.add(new ArrayList<>());
	    }
        // Then add u with v 
	    add(adj, 0, 1);
	    add(adj, 0, 2);
	    add(adj, 1, 3);
	    add(adj, 2, 4);
	    add(adj, 3, 5);
	    add(adj, 4, 5);
	    
	    printGraph(adj);
	}
}