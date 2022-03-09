import java.io.*;
import java.util.*;

public class Main {

    // Recursive
    public static int knapsackRec(int val[], int wt[], int cap, int n) {
        if (n == 0 || cap == 0) {
            return 0;
        }

        if (wt[n - 1] <= cap) {
            return Math.max(val[n - 1] + knapsackRec(val, wt, cap - wt[n - 1], n - 1),
                    knapsackRec(val, wt, cap, n - 1));
        } else {
            return knapsackRec(val, wt, cap, n - 1);
        }
    }

    // Memoization
    public static int knapsackMemo(int val[], int wt[], int cap, int n, int dp[][]) {
        if (n == 0 || cap == 0) {
            return 0;
        }

        if (dp[n][cap] != -1) {
            return dp[n][cap];
        }

        if (wt[n - 1] <= cap) {
            return dp[n][cap] = Math.max(val[n - 1] + knapsackMemo(val, wt, cap - wt[n - 1], n - 1, dp),
                    knapsackMemo(val, wt, cap, n - 1, dp));
        } else {
            return dp[n][cap] = knapsackMemo(val, wt, cap, n - 1, dp);
        }
    }

    // Tabulation
    public static int knapsackTab(int val[], int wt[], int cap, int n, int dp[][]) {

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (j - wt[i - 1] >= 0) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][cap];
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val[] = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        int wt[] = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        int cap = sc.nextInt();
        // int ans = knapsackRec(val,wt,cap,n);
        int dp[][] = new int[n + 1][cap + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsackTab(val, wt, cap, n, dp));
    }
}