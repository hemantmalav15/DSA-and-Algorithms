import java.util.*;

public class PrefixSum2dArr {
    public static int[][] prefixSum2DArr(int arr[][]) {
        // for finding prefix sum on 2d array we have to first find the sum on first row and on first col
        int res[][] = new int[arr.length][arr[0].length];
        // finding prefix sum on first col
        res[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            res[i][0] = (res[i - 1][0] + arr[i][0]);
        }
        
        // finding prefix sum on first row
        for (int j = 1; j < arr[0].length; j++) {
            res[0][j] = (res[0][j - 1] + arr[0][j]);
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                res[i][j] = (res[i - 1][j] + res[i][j - 1] + arr[i][j] - res[i - 1][j - 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int arr[][] = new int[n][m];
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[0].length; j++) {
        //         arr[i][j] = sc.nextInt();
        //     }
        // }
        int arr[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int res[][] = prefixSum2DArr(arr);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
