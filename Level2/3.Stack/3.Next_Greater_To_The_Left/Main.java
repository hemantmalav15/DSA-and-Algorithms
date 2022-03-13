import java.io.*;

public class Main {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] ngl = solve(a);
        display(ngl);
    }

    public static int[] solve(int[] arr) {
        int n = arr.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        st.push(n - 1);
        Arrays.fill(nge, -1);

        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                nge[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        return nge;
    }

}