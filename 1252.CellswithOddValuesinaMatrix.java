class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        int a = 0, b = 0;
        for(int[] cor : indices){
            int x = cor[0];
            int y = cor[1];
            a += (rows[x] = !rows[x]) ? 1 : -1;
            b += (cols[y] = !cols[y]) ? 1 : -1;
        }
        return a * (n - b) + b * (m - a);
    }
}
