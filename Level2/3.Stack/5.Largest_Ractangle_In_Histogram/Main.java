class Main {
    //Find Previous smaller to the left
    public int[] psl(int arr[]){
        int ps[] = new int[arr.length];
        Arrays.fill(ps,-1);
        Stack<Integer> st = new Stack<Integer>();

        st.push(arr.length-1);
        for(int i = arr.length-1; i >= 0; i--){
            while(st.size() > 0 && arr[i] < arr[st.peek()]){
                int idx = st.pop();
                ps[idx] = i;
            }
            st.push(i);
        }
        return ps;
    }
    
    //Find Next Smaller to the Right
    public int[] nsr(int arr[]){
        int n = arr.length;
        int ns[] = new int[n];
        
        //Fill Next smaller to the right array with length of the array so whenever we 
        //didnt get smaller to the right we consider the length of array as next smaller
        //Elements idx
        Arrays.fill(ns,n);
        Stack<Integer> st = new Stack<Integer>();
        
        st.push(0);
        for(int i = 1; i<n; i++){
            while(st.size() > 0 && arr[i] < arr[st.peek()]){
                int idx = st.pop();
                ns[idx] = i;
            }
            st.push(i);
        }
        return ns;
    }
    public int largestRectangleArea(int[] heights) {
        int ps[] = psl(heights);
        int ns[] = nsr(heights);
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<heights.length; i++){
            
            int w  = ns[i]- ps[i] - 1;
            int area = heights[i]*w;
            max = Math.max(max,area);
        }
        return max;
    }
}