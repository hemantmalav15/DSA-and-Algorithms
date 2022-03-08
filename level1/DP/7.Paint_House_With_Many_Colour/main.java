import java.util.*;

public class Main {

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
        // Fill first row as it is
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = arr[0][j];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < dp[0].length; k++) {
                    if (k != j) {
                        min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = min + arr[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < dp[0].length; k++) {
            min = Math.min(min, dp[n - 1][k]);
        }
        System.out.println(min);
    }
}