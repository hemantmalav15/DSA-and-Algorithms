class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        Stack<Integer> st = new Stack<Integer>();
        st.push(0);
        for (int i = 0; i < nums2.length; i++) {
            while (st.size() > 0 && nums2[st.peek()] < nums2[i]) {
                hm.put(nums2[st.pop()], nums2[i]);
            }
            st.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (hm.containsKey(nums1[i])) {
                nums1[i] = hm.get(nums1[i]);
            } else {
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}
