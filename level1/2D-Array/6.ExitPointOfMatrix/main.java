import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int dir = 0;
        int i = 0, j = 0;
        while (true) {
            dir += arr[i][j];
            dir = dir % 4;

            // right
            if (dir == 0) {
                j++;
            }
            // down
            else if (dir == 1) {
                i++;
            }
            // left
            else if (dir == 2) {
                j--;
            }
            // upper
            else if (dir == 3) {
                i--;
            }

            if (i < 0) {
                i++;
                break;
            } else if (i >= n) {
                i--;
                break;
            } else if (j < 0) {
                j++;
                break;
            } else if (j >= m) {
                j--;
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);
    }

}