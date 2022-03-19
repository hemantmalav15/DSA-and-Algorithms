class Main {

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) {

        // LeftMost Greater Element
        int lmg[] = new int[n];
        lmg[0] = arr[0];

        for (int i = 1; i < n; i++) {
            lmg[i] = Math.max(arr[i], lmg[i - 1]);
        }
        // RightMost Greater Element
        int rmg[] = new int[n];
        rmg[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rmg[i] = Math.max(arr[i], rmg[i + 1]);
        }

        int water[] = new int[n];
        for (int i = 0; i < n; i++) {
            water[i] = Math.min(lmg[i], rmg[i]) - arr[i];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += water[i];
        }
        return ans;
    }
}
