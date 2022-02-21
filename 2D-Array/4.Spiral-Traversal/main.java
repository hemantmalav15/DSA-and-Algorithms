import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int minr = 0, minc = 0;
        int maxr = n-1,maxc = m-1;

        int tne = m*n, count = 0;
        while(count < tne){
            // Print left wall
            for(int i = minr, j = minc; i <= maxr && count < tne; i++){
                System.out.println(arr[i][j]);
                count++;
            }
            minc++;
            // Print Bottom wall
            for(int j = minc, i = maxr; j <= maxc && count < tne; j++){
                System.out.println(arr[i][j]);
                count++;
            }
            maxr--;
            // Print Right wall
            for(int i = maxr, j = maxc; i >= minr && count < tne; i--){
                System.out.println(arr[i][j]);
                count++;
            }
            maxc--;
            // Print Upper wall
            for(int i = minr,j = maxc; j >= minc && count < tne; j--){
                System.out.println(arr[i][j]);
                count++;
            }
            minr++;
        }
    }

}