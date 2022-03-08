import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long xx = k * 1;
        long xy = k * (k - 1);

        long total = xx + xy;
        for (int i = 3; i <= n; i++) {
            xx = xy;
            xy = total * (k - 1);
            total = xx + xy;
        }
        System.out.println(total);
    }
}