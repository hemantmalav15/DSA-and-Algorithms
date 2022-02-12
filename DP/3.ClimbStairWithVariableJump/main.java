import java.io.*;
import java.util.*;

public class Main {

    // Tabulation
    public static int stairPathWithJump(int n, int arr[]){

        int dp[] = new int[n+1];
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--){
            
            for(int j = 1; j <= arr[i] && (i+j) < dp.length; j++){
                dp[i] += dp[i + j];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();

       int jump[] = new int[n];
       for(int i = 0; i<n; i++){
           jump[i] = sc.nextInt();
       }
       // Jump[i] denotes the jump we can take from ith position
       int paths = stairPathWithJump(n, jump);
       System.out.println(paths);
    }

}