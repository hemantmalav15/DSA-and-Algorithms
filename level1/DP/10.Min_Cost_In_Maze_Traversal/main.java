import java.io.*;
import java.util.*;

public class Main {

    // Recursive Solution
    public static int minCostInMaze(int arr[][], int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dc) {
            return arr[sr][sc];
        }
        int min = Integer.MAX_VALUE;

        if (sr + 1 <= dr) {
            min = Math.min(min, minCostInMaze(arr, sr + 1, sc, dr, dc));
        }
        if (sc + 1 <= dc) {
            min = Math.min(min, minCostInMaze(arr, sr, sc + 1, dr, dc));
        }

        return min + arr[sr][sc];
    }

    // Memoized Solution
    public static int minCostInMazeMemo(int arr[][], int sr, int sc, int dr, int dc, int dp[][]) {

        if (sr > dr || sc > dc) {
            return Integer.MAX_VALUE;
        }
        if (sr == sc && sc == dc) {
            return dp[sr][sc] = arr[sr][sc];
        }

        if (dp[sr][sc] > 0) {
            return dp[sr][sc];
        }

        int cost1 = minCostInMazeMemo(arr, sr + 1, sc, dr, dc, dp);
        int cost2 = minCostInMazeMemo(arr, sr, sc + 1, dr, dc, dp);

        int min = Math.min(cost1, cost2);
        return dp[sr][sc] = min + arr[sr][sc];
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int dp[][] = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = arr[i][j] + dp[i][j + 1];
                } else if (j == m - 1) {
                    dp[i][j] = arr[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        // int minCost = minCostInMazeMemo(arr,0,0,n-1,m-1);
        System.out.println(dp[0][0]);
    }

}