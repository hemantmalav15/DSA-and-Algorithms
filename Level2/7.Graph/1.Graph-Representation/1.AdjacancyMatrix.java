class AdjacancyMatrix {
    
    public static void printGraph(int adj[][]){
        for(int i = 0; i < adj.length; i++){
            for(int j = 0; j < adj.length; j++){
                if(adj[i][j] == 1){
                    System.out.println(i + " is connected with " + j);
                }
            }
        }
    }
    public static void add(int adj[][], int u, int v){
        adj[u][v] = 1;
        adj[v][u] = 1;
    }
	public static void main (String[] args) {
	    int v = 6;
	    
	    int adj[][] = new int[v][v];
	    add(adj, 0, 1);
	    add(adj, 0, 2);
	    add(adj, 1, 3);
	    add(adj, 2, 4);
	    add(adj, 3, 5);
	    add(adj, 4, 5);
	    
	    printGraph(adj);
	}
}