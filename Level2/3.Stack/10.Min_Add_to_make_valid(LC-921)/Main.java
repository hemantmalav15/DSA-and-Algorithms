import java.util.Stack;

public class Main {

    public int minAddToMakeValid(String s) {

        int count = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() == 0) {
                    count++;
                } else {
                    st.pop();
                }
            }
        }
        count += st.size();
        return count;
    }
}
