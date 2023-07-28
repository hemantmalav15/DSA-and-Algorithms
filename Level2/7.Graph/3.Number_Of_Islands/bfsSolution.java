import java.util.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    class Pair {
        int row;
        int col;

        public Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    //this is bfs algorithm to find islands
    private void bfs(char[][] grid, int row, int col, boolean vis[][]) {
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        q.add(new Pair(row, col));
        while (q.size() > 0) {

            Pair p = q.remove();

            // we have to make calls in all 8 directions where the value of row and col will
            // varry from (-1 to 1)
            // {(-1, -1),(-1, 0),(-1, 1),(0, -1),(0, 1),(1, -1),(1, 0),(1, 1)}
            // (0, 0) is the current row and col so we dont have to call this again

            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = delrow + p.row; // find the neighbour row
                    int ncol = delcol + p.col; // find the neighbour col

                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == '1'
                            && vis[nrow][ncol] == false) {
                        q.add(new Pair(nrow, ncol));
                        vis[nrow][ncol] = true;
                    }
                }
            }
        }
    }

    // Function to find the number of islands.
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
}