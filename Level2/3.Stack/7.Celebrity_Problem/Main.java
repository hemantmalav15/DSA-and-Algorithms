class Main {
    // Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int j = st.pop();
            int i = st.pop();

            if (M[i][j] == 1) {
                st.push(j);
            } else {
                st.push(i);
            }
        }
        int idx = st.pop();
        for (int i = 0; i < n; i++) {
            if (i != idx && (M[idx][i] == 1 || M[i][idx] == 0)) {
                return -1;
            }
        }
        return idx;
    }
}