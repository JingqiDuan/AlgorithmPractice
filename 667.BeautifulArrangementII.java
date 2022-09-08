class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int i = 0;
        int p = 1, q = n;
        for (int j = 0; j < k; j++) {
            if (j % 2 == 0) {
                ans[i++] = p++;
            } else {
                ans[i++] = q--;
            }
        }
        if (k % 2 == 0) {
            while (i < n) {
                ans[i++] = q--;
            }
        } else {
            while (i < n) {
                ans[i++] = p++;
            }
        }
        return ans;
    }
}
