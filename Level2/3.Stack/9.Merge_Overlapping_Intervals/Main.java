import java.util.*;

public class Main {

    public int[][] overlappedInterval(int[][] Intervals) {
        Arrays.sort(Intervals, (a, b) -> {
            return a[0] - b[0];
        });

        Stack<int[]> st = new Stack<>();
        st.push(Intervals[0]);

        for (int i = 1; i < Intervals.length; i++) {
            int top[] = st.pop(); // get arr from stack's top for merging
            int s1 = top[0];
            int e1 = top[1];

            int s2 = Intervals[i][0];
            int e2 = Intervals[i][1];

            if (e1 >= s2) {
                int et = Math.max(e1, e2);
                st.push(new int[] { s1, et });
            } else {
                st.push(top);
                st.push(Intervals[i]);
            }
        }
        int ans[][] = new int[st.size()][2];
        for (int i = ans.length - 1; i >= 0; i--) {
            int top[] = st.pop();
            ans[i][0] = top[0];
            ans[i][1] = top[1];
        }
        return ans;
    }
}
