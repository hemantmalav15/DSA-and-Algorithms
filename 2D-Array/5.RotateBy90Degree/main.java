import java.io.*;
import java.util.*;

public class Main {

    public static void swap(int arr[][],int i, int j){
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
    public static void transpose(int arr[][], int n){
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                swap(arr,i,j);
            }
        }
    }

    public static void rotate(int arr[][],int n){
        for(int i = 0; i<n; i++){
            int minc = 0, maxc = n-1;
            while(minc < maxc){
                int temp = arr[i][minc];
                arr[i][minc] = arr[i][maxc];
                arr[i][maxc] = temp;

                minc++;
                maxc--;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[][] = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        transpose(arr,n);
        rotate(arr,n);
        display(arr);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}