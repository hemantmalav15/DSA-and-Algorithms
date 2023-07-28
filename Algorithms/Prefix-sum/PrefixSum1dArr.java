class PrefixSum1dArr {
    public static int[] prefixSum(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int res[] = prefixSum(arr);

        for (int e : res) {
            System.out.print(e + " ");
        }
        System.out.println();
        // if we have to perform some queries on prefix sum

        // for example find sum between [0, 4] or [3,5] how we can calculate as we know
        // arr[4] contains sum from [0, 4] so in this case we can simply return this for
        // [3, 5] we can do this as arr[5] contains sum of numbers from [0, 5] then
        // subtract sum[0, 2]

        // sum from [0 , 5]
        System.out.println(res[5]);
        // sum from [3, 5]
        System.out.println(res[5] - res[2]);
    }
}