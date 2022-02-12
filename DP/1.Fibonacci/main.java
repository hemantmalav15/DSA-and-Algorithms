import java.io.*;
import java.util.*;

public class Main{

public static int fib(int n, int dp[]){
    if(n <= 1){
        return dp[n] = n;
    }

    if(dp[n] != 0){
        return dp[n];
    }

    int nm1 = fib(n-1, dp);
    int nm2 = fib(n-2, dp);

    int fibn = nm1 + nm2;
    return dp[n] = fibn;
}

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int dp[] = new int[n+1];
    int nthFib = fib(n,dp);
    System.out.println(nthFib);
 }

}