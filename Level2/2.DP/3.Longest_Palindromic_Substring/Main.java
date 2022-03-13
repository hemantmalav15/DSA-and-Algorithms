import java.io.*;
import java.util.*;

public class Main {
    
    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = reverse(s1);
        
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        
        // Longest Palindromic Substring
        int ans = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(ans);
    }

}