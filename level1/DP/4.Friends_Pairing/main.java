import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int dp[] = new int[N + 1];
        for (int n = 0; n < dp.length; n++) {
            if (n <= 2) {
                dp[n] = n;
                continue;
            }
            int single = dp[n - 1];
            int pair = dp[n - 2];

            dp[n] = single + pair * (n - 1);
        }
        System.out.println(dp[N]);
    }

}