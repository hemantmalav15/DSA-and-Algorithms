import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        int dp[] = new int[amt + 1];
        dp[0] = 1;
        for (int j = 1; j < dp.length; j++) {
            for (int i = 0; i < a.length; i++) {
                if (j - a[i] >= 0) {
                    dp[j] += dp[j - a[i]];
                }
            }
        }
        System.out.println(dp[amt]);
    }
}