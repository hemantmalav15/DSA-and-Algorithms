import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            long ob = 1;
            long os = 1;

            for (int i = 2; i <= n; i++) {
                long nb = os;
                long ns = (ob + os);

                os = ns;
                ob = nb;
            }
            long total = os + ob;
            System.out.println(total * total);
        }
    }

}