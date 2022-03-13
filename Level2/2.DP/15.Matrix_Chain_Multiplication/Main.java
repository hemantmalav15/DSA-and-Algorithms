import java.io.*;
import java.util.*;

public class Main {

    static int dp[][];

    // Memoized Solution
    public static int mcmMemo(int arr[], int i, int j) {
        // Base Condition
        if (i >= j) {
            return 0;
        }

        // Check in matrix if ans is already computed or not
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // For Loop
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int tempAns = mcmMemo(arr, i, k) + mcmMemo(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (tempAns < min) {
                min = tempAns;
            }
        }
        return dp[i][j] = min;
    }

    // Recursive Solution
    public static int mcmRec(int arr[], int i, int j) {
        // Base Condition
        if (i >= j) {
            return 0;
        }

        // For Loop
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int tempAns = mcmRec(arr, i, k) + mcmRec(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (tempAns < min) {
                min = tempAns;
            }
        }
        return min;
    }

    public static int mcm(int[] arr) {
        int n = arr.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return mcmMemo(arr, 1, n - 1);
    }

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            System.out.println(mcm(arr));
        }
    }

}