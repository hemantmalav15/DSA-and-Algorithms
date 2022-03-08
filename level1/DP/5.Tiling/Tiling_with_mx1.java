import java.io.*;
import java.util.*;

public class Main {
    // Memoization
    public static int tilingMemo(int m, int n, int dp[]) {

        if (n < m) {
            return dp[n] = 1;
        }
        if (n == m) {
            return dp[n] = 2;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans1 = tilingMemo(m, n - 1, dp);
        int ans2 = tilingMemo(m, n - m, dp);
        return dp[n] = ans1 + ans2;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int dp[] = new int[n + 1];
        int ans = tilingMemo(m, n, dp);
        System.out.println(ans);

        // Tabulation
        for (int i = 1; i < dp.length; i++) {
            if (i < m) {
                dp[i] = 1;
            } else if (i == m) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        System.out.println(dp[n]);
    }
}