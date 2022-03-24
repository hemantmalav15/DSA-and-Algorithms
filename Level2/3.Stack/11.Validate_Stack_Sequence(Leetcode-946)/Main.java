import java.util.Stack;

public class Main {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();

        int idx = 0;
        for (int e : pushed) {

            st.push(e);
            while (st.size() > 0 && st.peek() == popped[idx]) {
                st.pop();
                idx++;
            }
        }
        return idx == popped.length;
    }
}
