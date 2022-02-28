import java.io.*;
import java.util.*;

public class Main{

public static void printMatrix(int arr[][]){
    for(int i = 0; i<arr.length; i++){
        for(int j = 0; j<arr[0].length; j++){
            System.out.print(arr[i][j] + " ");
        }
        System.out.println();
    }
}

public static void matrixMultiplication(int a[][],int b[][],int r1,int c1, int r2,int c2){

    if(c1 != r2){
        System.out.println("Invalid input");
        return;
    }
    
    int matrix[][] = new int[r1][c2];
    for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix[0].length; j++){
            for(int k = 0; k < c1; k++){
                matrix[i][j] += a[i][k]*b[k][j];
            }
        }
    }
    printMatrix(matrix);
}

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int r1 = sc.nextInt();
    int c1 = sc.nextInt();
    int a[][] = new int[r1][c1];

    for(int i = 0; i<r1; i++){
        for(int j = 0; j<c1; j++){
            a[i][j] = sc.nextInt();
        }
    }

    int r2 = sc.nextInt();
    int c2 = sc.nextInt();
    int b[][] = new int[r2][c2];

    for(int i = 0; i<r2; i++){
        for(int j = 0; j<c2; j++){
            b[i][j] = sc.nextInt();
        }
    }
    matrixMultiplication(a,b,r1,c1,r2,c2);
 }

}