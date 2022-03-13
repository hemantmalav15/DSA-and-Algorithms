import java.io.*;
import java.util.*;

public class Main {

    // Recursive Longest Common Subsequence
    public static int LCS_Rec(String x, String y, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            return 1 + LCS_Rec(x, y, n - 1, m - 1);
        } else {
            return Math.max(LCS_Rec(x, y, n - 1, m), LCS_Rec(x, y, n, m - 1));
        }
    }

    static int dp[][];

    // Memoized Longest Common Subsequence
    public static int LCS_Memo(String x, String y, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            return dp[n][m] = 1 + LCS_Memo(x, y, n - 1, m - 1);
        } else {
            return dp[n][m] = Math.max(LCS_Memo(x, y, n - 1, m), LCS_Memo(x, y, n, m - 1));
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int n = s1.length();
        int m = s2.length();
        dp = new int[n + 1][m + 1];
        // for(int i = 0; i<dp.length; i++){
        // for(int j = 0; j<dp[0].length; j++){
        // dp[i][j] = -1;
        // }
        // }
        // int ans = LCS(s1,s2,n,m);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }

}