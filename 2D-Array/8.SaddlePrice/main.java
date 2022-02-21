import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[][] = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int row = 0; row < n; row++){

            int min = arr[row][0];
            int colIdx = 0;
            for(int col = 0; col < n; col++){
                if(arr[row][col] < min){
                    min = arr[row][col];
                    colIdx = col;
                }
            }
            boolean isMax = true;
            for(int r = 0; r < n; r++){
                if(arr[r][colIdx] > min){
                    isMax = false;
                    break;
                }
            }
            if(isMax){
                System.out.println(arr[row][colIdx]);
                return;
            }
        }
        System.out.println("Invalid input");
    }

}