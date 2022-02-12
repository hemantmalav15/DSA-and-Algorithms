import java.io.*;
import java.util.*;

public class Main {
    // Recursive
    public static int stairPathRec(int n){

        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        int x = stairPathRec(n-1);
        int y = stairPathRec(n-2);
        int z = stairPathRec(n-3);

        int totalPath = x + y + z;
        return totalPath;
    }
    // memoized
    public static int stairPath(int n, int dp[]){

        if(n < 0){
            return 0;
        }
        if(n == 0){
            return dp[n] = 1;
        }
        int x = stairPath(n-1,dp);
        int y = stairPath(n-2,dp);
        int z = stairPath(n-3,dp);

        int totalPath = x + y + z;
        return dp[n] = totalPath;
    }
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int dp[] = new int[n + 1];
       int path = stairPath(n, dp);
       System.out.println(path);
    }

}
