class Solution {
    // Function to find the number of islands.
    public void findIslands(char arr[][],int sr,int sc, boolean[][]visited){
        
        if(sr < 0 || sc < 0 || sr >= arr.length || sc >= arr[0].length || visited[sr][sc] == true || arr[sr][sc] == '0'){
            return;
        }
        visited[sr][sc] = true;
        findIslands(arr,sr - 1, sc, visited); // top
        findIslands(arr,sr + 1, sc, visited); // down
        findIslands(arr,sr, sc - 1, visited); // left
        findIslands(arr,sr, sc + 1, visited); // right
        findIslands(arr,sr - 1, sc - 1, visited); // left top diagonal
        findIslands(arr,sr + 1, sc - 1, visited); // left down diagonal
        findIslands(arr,sr - 1, sc + 1, visited); // right top diagonal
        findIslands(arr,sr + 1, sc + 1, visited); // right down diagonal
    }
    public int numIslands(char[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    findIslands(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
}