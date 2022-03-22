import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            // n Number of Queens are there
            int n = sc.nextInt();
            // we have to place these n queens in this matrix such that no 2 queens are in
            // the
            // same col, in the same row, at left diagonally and right diagonally
            int arr[][] = new int[n][n];

            printNQueens(arr, "", 0);
        }

    }

    public static void printNQueens(int[][] chess, String qsf, int row) {

        if (row == chess.length) {
            System.out.print(qsf + ".");
            System.out.println();
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (isSafePlaceForQueen(chess, row, col) == true) {
                chess[row][col] = 1;
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean isSafePlaceForQueen(int chess[][], int row, int col) {
        // Check if the col contains a queen already or not
        for (int i = row, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        // Check if left daigonal contains a queen or not
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        // Check if right diagonal contains a queen or not
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

}
