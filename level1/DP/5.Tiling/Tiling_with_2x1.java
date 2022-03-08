import java.io.*;
import java.util.*;

public class Main {

    public static int tiling(int n, int dp[]) {

        if (n <= 2) {
            return dp[n] = n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans1 = tiling(n - 1, dp);
        int ans2 = tiling(n - 2, dp);
        return dp[n] = ans1 + ans2;
    }
    // Optimised Code
    public static int waysOpti(int n){
        
        int one = 1;
        int two = 2;
        for(int i = 3; i<=n; i++)
            {
                int myAns = one + two;
                one = two;
                two = myAns;
            }
        return two;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int dp[] = new int[n + 1];
        // int ans = tiling(n,dp);
        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        System.out.println(dp[n]);
    }
}