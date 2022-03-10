import java.util.*;

public class Main {

    static int mod = (int) 1e9 + 7;

    public static long countStrings(int n) {

        long oldCountZero = 1;
        long oldCountOne = 1;

        for (int i = 2; i <= n; i++) {
            long nCountZero = oldCountOne;
            long nCountOne = (oldCountZero + oldCountOne) % mod;

            oldCountZero = nCountZero;
            oldCountOne = nCountOne;
        }

        return ((oldCountZero + oldCountOne) % mod);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(countStrings(n));
    }

}